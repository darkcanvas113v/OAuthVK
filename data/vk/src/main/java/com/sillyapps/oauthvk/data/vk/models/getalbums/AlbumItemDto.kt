package com.sillyapps.oauthvk.data.vk.models.getalbums

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumItemDto(
  @Json(name = "id")
  val id: Int,

  @Json(name = "can_delete")
  val canDelete: Boolean,

  @Json(name = "created")
  val created: Long,

  @Json(name = "description")
  val description: String,

  @Json(name = "owner_id")
  val ownerId: Int,

  @Json(name = "privacy_comment")
  val privacyComment: PrivacySettingsDto,

  @Json(name = "privacy_view")
  val privacyView: PrivacySettingsDto,

  @Json(name = "size")
  val size: Int,

  @Json(name = "thumb_id")
  val thumbId: Int,

  @Json(name = "thumb_is_last")
  val thumbIsLast: Int,

  @Json(name = "title")
  val title: String,

  @Json(name = "updated")
  val updated: Long
)