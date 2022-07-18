package com.sillyapps.oauthvk.data.vk.models.getalbum

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoSizeDto(
  @Json(name = "height")
  val height: Int,

  @Json(name = "width")
  val width: Int,

  @Json(name = "type")
  val type: String,

  @Json(name = "url")
  val url: String
)