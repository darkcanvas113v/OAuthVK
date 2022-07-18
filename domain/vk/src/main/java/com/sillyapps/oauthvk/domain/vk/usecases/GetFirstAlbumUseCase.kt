package com.sillyapps.oauthvk.domain.vk.usecases

import com.sillyapps.core.util.model.Resource
import com.sillyapps.oauthvk.domain.vk.VkRepository
import com.sillyapps.oauthvk.domain.vk.models.Album
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFirstAlbumUseCase @Inject constructor(
  private val repo: VkRepository
) {

  operator fun invoke(): Flow<Resource<Album>> = flow {
    emit(Resource.Loading())

    when (val albumsRes = repo.getAlbums()) {
      is Resource.Error -> {
        emit(Resource.Error(albumsRes.message))
      }
      is Resource.Success -> {
        val albums = albumsRes.data
        if (albums.list.isEmpty()) {
          emit(Resource.Error("No albums."))
        } else {
          val album = repo.getAlbum(albums.list[0].id)

          if (album is Resource.Error)
            emit(Resource.Error(album.message))
          else if (album is Resource.Success)
            emit(Resource.Success(album.data))
        }
      }
      else -> {}
    }
  }
}
