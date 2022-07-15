package com.sillyapps.oauthvk.data.auth

import com.sillyapps.oauthvk.data.auth.datasources.accessinfo.AccessInfoDataSource
import com.sillyapps.oauthvk.data.auth.datasources.authurl.AuthUrlDataSource
import com.sillyapps.oauthvk.data.auth.model.toDataModel
import com.sillyapps.oauthvk.data.auth.model.toDomainModel
import com.sillyapps.oauthvk.domain.auth.AuthRepository
import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
  private val accessInfoDataSource: AccessInfoDataSource,
  private val authUrlDataSource: AuthUrlDataSource
): AuthRepository {

  override suspend fun getAuthorizationPageUrl(): String {
    return authUrlDataSource.getUrl()
  }

  override fun saveAccessInformation(response: String) {
    accessInfoDataSource.saveAccessInfo(response)
  }

  override suspend fun getAccessInformation(): AccessInfo? {
    return accessInfoDataSource.getAccessInfo()?.toDomainModel()
  }

}