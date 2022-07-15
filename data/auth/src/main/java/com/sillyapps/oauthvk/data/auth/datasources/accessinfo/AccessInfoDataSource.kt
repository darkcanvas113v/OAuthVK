package com.sillyapps.oauthvk.data.auth.datasources.accessinfo

import com.sillyapps.oauthvk.data.auth.model.AccessInfoDataModel
import com.sillyapps.oauthvk.data.auth.model.AccessInfoState
import kotlinx.coroutines.flow.Flow

interface AccessInfoDataSource {

  fun getAccessInfoState(): Flow<AccessInfoState>

  suspend fun getAccessInfo(): AccessInfoDataModel?

  fun saveAccessInfo(response: String)

}