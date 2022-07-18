package com.sillyapps.oauthvk.features.album.ui

import com.sillyapps.oauthvk.features.album.model.AlbumScreenState
import kotlinx.coroutines.flow.Flow

interface AlbumScreenStateHolder {

  fun getState(): Flow<AlbumScreenState>

}