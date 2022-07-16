package com.sillyapps.oauthvk.data.auth.model

import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AccessInfoDataModel(
  val token: String,
  val createdIn: Long,
  val expiresIn: Long,
  val userId: Int
)

fun AccessInfoDataModel.toDomainModel(): AccessInfo {
  return AccessInfo(token, createdIn, expiresIn, userId)
}

fun AccessInfo.toDataModel(): AccessInfoDataModel {
  return AccessInfoDataModel(token, createdIn, expiresIn, userId)
}

fun AccessInfoDataModel.isValid(): Boolean {
  // some offset to minimize cases then token is invalidated while user interacting with the app
  val eps = 5 * 60000

  return token.isNotBlank() &&
      System.currentTimeMillis() - createdIn > expiresIn + eps
}