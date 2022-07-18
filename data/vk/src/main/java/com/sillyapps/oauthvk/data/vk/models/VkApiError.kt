package com.sillyapps.oauthvk.data.vk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VkApiError(
  @Json(name = "error_code")
  val errorCode: Int,

  @Json(name = "error_message")
  val errorMessage: String,

  @Json(name = "request_params")
  val requestParams: List<RequestParam>
)

@JsonClass(generateAdapter = true)
data class RequestParam(
  val key: String,
  val value: String
)