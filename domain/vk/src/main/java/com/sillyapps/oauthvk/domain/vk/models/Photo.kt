package com.sillyapps.oauthvk.domain.vk.models

data class Photo(
  val id: Int,
  val ownerId: Int,
  val url: String,
  val createdIn: Long
)

fun Photo.getStringId() = "${ownerId}_$id"