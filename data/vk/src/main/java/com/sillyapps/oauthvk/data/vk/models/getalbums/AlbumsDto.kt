package com.sillyapps.oauthvk.data.vk.models.getalbums

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumsDto(
  @Json(name = "count")
  val count: Int,

  @Json(name = "items")
  val albums: List<AlbumItemDto>
)