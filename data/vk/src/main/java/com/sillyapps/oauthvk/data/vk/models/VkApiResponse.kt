package com.sillyapps.oauthvk.data.vk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VkApiResponse<T>(
  @Json(name = "response")
  val body: T?,
  val error: VkApiError?
)
