package com.sillyapps.oauthvk.data.auth.model

import com.sillyapps.oauthvk.data.auth.AuthConstants
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

fun AccessInfoDataModel.isValid(): Boolean {
  // some offset to minimize cases then token is invalidated while user interacting with app
  val eps = 5 * 60000

  return token.isNotBlank() &&
      System.currentTimeMillis() - createdIn < expiresIn - eps
}

fun accessInfoFromUrl(response: String): AccessInfoDataModel? {
  val map = response
    .removePrefix(AuthConstants.SUCCESS_URL)
    .split("&")
    .associate {
      val str = it.split("=")
      str[0] to str[1]
    }

  val userId = map["user_id"]?.toIntOrNull() ?: return null
  val expiresIn = map["expires_in"]?.toLongOrNull() ?: return null
  val token = map["access_token"] ?: return null

  val createdIn = System.currentTimeMillis()

  return AccessInfoDataModel(
    userId = userId,
    createdIn = createdIn,
    expiresIn = expiresIn * 1000,
    token = token
  )
}