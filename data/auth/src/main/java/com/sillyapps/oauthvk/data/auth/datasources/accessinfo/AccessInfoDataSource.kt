package com.sillyapps.oauthvk.data.auth.datasources.accessinfo

import com.sillyapps.oauthvk.data.auth.model.AccessInfoDataModel
import com.sillyapps.oauthvk.domain.auth.model.AccessInfoState
import kotlinx.coroutines.flow.Flow

interface AccessInfoDataSource {

  fun getAccessInfoState(): Flow<AccessInfoState>

  fun getAccessInfo(): AccessInfoDataModel?

  fun saveAccessInfo(response: String)

  fun forgetAccessInfo()

}