package com.sillyapps.oauthvk.data.auth.model

import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AccessInfoDataModel(
  val token: String,
  val expiresIn: Long,
  val userId: Int
)

fun AccessInfoDataModel.toDomainModel(): AccessInfo {
  return AccessInfo(token, expiresIn, userId)
}

fun AccessInfo.toDataModel(): AccessInfoDataModel {
  return AccessInfoDataModel(token, expiresIn, userId)
}

fun AccessInfoDataModel.isValid(): Boolean {
  return token.isNotBlank() && expiresIn > 0
}