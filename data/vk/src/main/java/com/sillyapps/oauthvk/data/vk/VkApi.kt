package com.sillyapps.oauthvk.data.vk

import com.sillyapps.oauthvk.data.vk.models.getalbum.AlbumDto
import com.sillyapps.oauthvk.data.vk.models.getalbums.AlbumsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface VkApi {

  @GET("/method/photos.getAlbums?")
  suspend fun getAlbums(): AlbumsDto

  @GET("/method/photos.get?")
  suspend fun getAlbum(@Query("album_id") albumId: Int): AlbumDto

}