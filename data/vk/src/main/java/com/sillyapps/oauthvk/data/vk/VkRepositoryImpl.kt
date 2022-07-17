package com.sillyapps.oauthvk.data.vk

import com.sillyapps.core.di.IOCoroutineScope
import com.sillyapps.core.di.IODispatcher
import com.sillyapps.core.util.model.Resource
import com.sillyapps.oauthvk.data.vk.models.converters.toDomainModel
import com.sillyapps.oauthvk.domain.vk.VkRepository
import com.sillyapps.oauthvk.domain.vk.models.Album
import com.sillyapps.oauthvk.domain.vk.models.Albums
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class VkRepositoryImpl @Inject constructor(
  private val vkApi: VkApi,
  @IODispatcher private val ioDispatcher: CoroutineDispatcher,
  @IOCoroutineScope private val ioScope: CoroutineScope
): VkRepository {

  private val albums = MutableStateFlow<Resource<Albums>>(
    value = Resource.Initial()
  )

  private val album = MutableStateFlow<Resource<Album>>(
    value = Resource.Initial()
  )

  override fun getAlbums(forceLoad: Boolean): Flow<Resource<Albums>> {
    ioScope.launch(ioDispatcher) {
      val shouldLoad = forceLoad || albums.value is Resource.Initial || albums.value is Resource.Error
      if (shouldLoad) {
        val value = vkApi.getAlbums().toDomainModel()

        albums.value = Resource.Success(value)
      }
    }

    return albums
  }

  override fun getAlbumPhotos(albumId: Int, forceLoad: Boolean): Flow<Resource<Album>> {
    ioScope.launch(ioDispatcher) {
      val shouldLoad = forceLoad || album.value is Resource.Initial || album.value is Resource.Error
      if (shouldLoad) {
        val value = vkApi.getAlbum(albumId).toDomainModel()

        album.value = Resource.Success(value)
      }
    }

    return album
  }


}