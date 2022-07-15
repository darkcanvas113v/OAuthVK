package com.sillyapps.oauthvk.domain.auth

import com.sillyapps.oauthvk.domain.auth.model.AccessInfo

interface AuthRepository {

  suspend fun getAuthorizationPageUrl(): String

  fun saveAccessInformation(response: String)

  suspend fun getAccessInformation(): AccessInfo?

}