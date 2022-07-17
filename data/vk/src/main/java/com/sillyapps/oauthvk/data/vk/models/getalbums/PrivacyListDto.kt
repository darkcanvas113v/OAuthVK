package com.sillyapps.oauthvk.data.vk.models.getalbums

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PrivacyListDto(
    @Json(name = "allowed")
    val allowed: List<Int>,

    @Json(name = "allowed")
    val excluded: List<Int>
)