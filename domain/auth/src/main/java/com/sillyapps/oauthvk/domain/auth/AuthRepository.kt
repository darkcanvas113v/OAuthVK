package com.sillyapps.oauthvk.domain.auth

import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import com.sillyapps.oauthvk.domain.auth.model.AccessInfoState
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

  suspend fun getAuthorizationPageUrl(): String

  fun saveAccessInformation(response: String)

  suspend fun getAccessInformation(): AccessInfo?

  fun getAccessInfoState(): Flow<AccessInfoState>

}