package com.sillyapps.oauthvk.data.vk

import com.sillyapps.oauthvk.data.vk.models.VkApiResponse
import com.sillyapps.oauthvk.data.vk.models.getalbum.AlbumDto
import com.sillyapps.oauthvk.data.vk.models.getalbum.PhotoDto
import com.sillyapps.oauthvk.data.vk.models.getalbums.AlbumsDto
import com.sillyapps.oauthvk.domain.vk.models.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VkApi {

  @GET("/method/photos.getAlbums?")
  suspend fun getAlbums(): Response<VkApiResponse<AlbumsDto>>

  @GET("/method/photos.get?")
  suspend fun getAlbum(@Query("album_id") albumId: Int): Response<VkApiResponse<AlbumDto>>

  @GET("/method/photos.getById?")
  suspend fun getPhoto(@Query("photos") photoIds: String): Response<VkApiResponse<List<PhotoDto>>>

}