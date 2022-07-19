package com.sillyapps.oauthvk.features.photo.ui

import com.sillyapps.oauthvk.features.photo.model.PhotoScreenState
import kotlinx.coroutines.flow.Flow

interface PhotoScreenStateHolder {

  fun getState(): Flow<PhotoScreenState>

}