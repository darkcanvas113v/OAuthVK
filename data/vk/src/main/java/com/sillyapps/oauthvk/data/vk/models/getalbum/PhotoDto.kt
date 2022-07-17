package com.sillyapps.oauthvk.data.vk.models.getalbum

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoDto(
  @Json(name = "album_id")
  val albumId: Int,

  @Json(name = "date")
  val date: Long,

  @Json(name = "has_tags")
  val hasTags: Boolean,

  @Json(name = "id")
  val id: Int,

  @Json(name = "owner_id")
  val ownerId: Int,

  @Json(name = "sizes")
  val sizes: List<PhotoSizeDto>,

  @Json(name = "text")
  val text: String
)