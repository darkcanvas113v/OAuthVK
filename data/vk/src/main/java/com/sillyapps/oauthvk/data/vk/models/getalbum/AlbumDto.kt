package com.sillyapps.oauthvk.data.vk.models.getalbum

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumDto(
  @Json(name = "count")
  val photoCount: Int,

  @Json(name = "items")
  val photos: List<PhotoDto>
)