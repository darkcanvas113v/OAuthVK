package com.sillyapps.oauthvk.data.auth.datasources.accessinfo

import android.content.SharedPreferences
import com.sillyapps.oauthvk.data.auth.AuthConstants
import com.sillyapps.oauthvk.data.auth.model.AccessInfoDataModel
import com.sillyapps.oauthvk.data.auth.model.AccessInfoState
import com.sillyapps.oauthvk.data.auth.model.isValid
import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccessInfoDataSourceImpl @Inject constructor(
  private val sharedPref: SharedPreferences,
  private val scope: CoroutineScope
) : AccessInfoDataSource {

  private val adapter = Moshi.Builder().build().adapter(AccessInfoDataModel::class.java)

  private val accessInfoState = MutableStateFlow<AccessInfoState>(AccessInfoState.Invalid)

  init {
    scope.launch {
      val accessInfo = getAccessInfo()

      if (accessInfo != null && accessInfo.isValid()) {
        accessInfoState.value = AccessInfoState.Valid
      }
    }
  }

  override fun getAccessInfoState(): Flow<AccessInfoState> = accessInfoState

  override suspend fun getAccessInfo(): AccessInfoDataModel? {
    val json = sharedPref.getString(ACCESS_INFO, null) ?: return null

    return adapter.fromJson(json)
  }

  override fun saveAccessInfo(response: String) {
    scope.launch {
      val accessInfo = accessInfoFromUrl(response) ?: return@launch

      val json = adapter.toJson(accessInfo)

      sharedPref.edit().putString(ACCESS_INFO, json).apply()
      accessInfoState.value = AccessInfoState.Valid
    }
  }

  companion object {
    private const val ACCESS_INFO = "ACCESS_INFO"

    fun accessInfoFromUrl(response: String): AccessInfoDataModel? {
      val map = response
        .removePrefix(AuthConstants.SUCCESS_URL)
        .split("&")
        .associate {
          val str = it.split("=")
          str[0] to str[1]
        }

      val userId = map["user_id"]?.toIntOrNull() ?: return null
      val expiresIn = map["expires_in"]?.toLongOrNull() ?: return null
      val token = map["access_token"] ?: return null

      return AccessInfoDataModel(
        userId = userId,
        expiresIn = expiresIn,
        token = token
      )
    }
  }

}