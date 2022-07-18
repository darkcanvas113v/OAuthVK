package com.sillyapps.oauthvk.data.auth.datasources.accessinfo

import android.content.SharedPreferences
import androidx.core.content.edit
import com.sillyapps.oauthvk.data.auth.model.AccessInfoDataModel
import com.sillyapps.oauthvk.data.auth.model.accessInfoFromUrl
import com.sillyapps.oauthvk.data.auth.model.isValid
import com.sillyapps.oauthvk.domain.auth.model.AccessInfoState
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccessInfoDataSourceImpl @Inject constructor(
  private val sharedPref: SharedPreferences,
  private val scope: CoroutineScope,
  private val ioDispatcher: CoroutineDispatcher
) : AccessInfoDataSource {

  private val adapter = Moshi.Builder().build().adapter(AccessInfoDataModel::class.java)

  private val accessInfo = MutableStateFlow<AccessInfoDataModel?>(null)

  private var isLoaded: Boolean = false

  init {
    scope.launch(ioDispatcher) {
      loadAccessInfo()
      isLoaded = true
    }
  }

  private fun loadAccessInfo() {
    val json = sharedPref.getString(ACCESS_INFO, null)

    if (json.isNullOrBlank()) {
      accessInfo.value = null
      return
    }

    accessInfo.value = adapter.fromJson(json)
  }

  override fun getAccessInfoState(): Flow<AccessInfoState> = accessInfo.map {
    if (!isLoaded)
      AccessInfoState.Initial
    else if (it != null && it.isValid())
      AccessInfoState.Valid
    else
      AccessInfoState.Invalid
  }

  override fun getAccessInfo(): AccessInfoDataModel? {
    return accessInfo.value
  }

  override fun saveAccessInfo(response: String) {
    scope.launch(ioDispatcher) {
      val value = accessInfoFromUrl(response) ?: return@launch

      val json = adapter.toJson(value)

      sharedPref.edit().putString(ACCESS_INFO, json).apply()
      accessInfo.value = value
    }
  }

  override fun forgetAccessInfo() {
    scope.launch(ioDispatcher) {
      sharedPref.edit().remove(ACCESS_INFO).apply()
      accessInfo.value = null
    }
  }

  companion object {
    private const val ACCESS_INFO = "ACCESS_INFO"
  }

}