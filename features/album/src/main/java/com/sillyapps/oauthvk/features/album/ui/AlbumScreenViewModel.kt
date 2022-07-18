package com.sillyapps.oauthvk.features.album.ui

import androidx.lifecycle.ViewModel
import com.sillyapps.core.util.model.Resource
import com.sillyapps.oauthvk.domain.auth.usecases.ForgetAccessTokenUseCase
import com.sillyapps.oauthvk.domain.vk.usecases.GetFirstAlbumUseCase
import com.sillyapps.oauthvk.features.album.model.AlbumScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AlbumScreenViewModel @Inject constructor(
  private val getFirstAlbumUseCase: GetFirstAlbumUseCase,
  private val forgetAccessTokenUseCase: ForgetAccessTokenUseCase
): ViewModel(), AlbumScreenStateHolder {

  override fun getState(): Flow<AlbumScreenState> {
    return getFirstAlbumUseCase().map {
      when (it) {
        is Resource.Loading -> AlbumScreenState(isLoading = true)
        is Resource.Success -> AlbumScreenState(
          isLoading = false,
          photos = it.data.photos
        )
        is Resource.Error -> AlbumScreenState(errorMessage = it.message)
      }
    }
  }

  override fun logout() {
    forgetAccessTokenUseCase()
  }

}