package com.sillyapps.oauthvk.features.auth_screen.ui

import com.sillyapps.oauthvk.features.auth_screen.model.AuthScreenState
import kotlinx.coroutines.flow.Flow

interface AuthScreenStateHolder {

  fun getState(): Flow<AuthScreenState>

}