package com.sillyapps.oauthvk.data.vk.models.getalbums

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PrivacySettingsDto(
  @Json(name = "category")
  val category: String,

  @Json(name = "lists")
  val lists: PrivacyListDto,

  @Json(name = "owners")
  val owners: PrivacyListDto
)