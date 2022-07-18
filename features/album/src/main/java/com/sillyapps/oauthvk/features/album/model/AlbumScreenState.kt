package com.sillyapps.oauthvk.features.album.model

import com.sillyapps.oauthvk.domain.vk.models.Photo

data class AlbumScreenState(
  val isLoading: Boolean = true,
  val photos: List<Photo> = emptyList(),
  val errorMessage: String? = null
)