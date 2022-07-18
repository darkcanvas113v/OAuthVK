package com.sillyapps.oauthvk.domain.vk

import com.sillyapps.core.util.model.Resource
import com.sillyapps.oauthvk.domain.vk.models.Album
import com.sillyapps.oauthvk.domain.vk.models.AlbumItem
import com.sillyapps.oauthvk.domain.vk.models.Albums
import com.sillyapps.oauthvk.domain.vk.models.Photo
import kotlinx.coroutines.flow.Flow

interface VkRepository {

  suspend fun getAlbums(): Resource<Albums>

  suspend fun getAlbum(albumId: Int): Resource<Album>

}