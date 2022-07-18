package com.sillyapps.oauthvk.domain.auth.model

/**
 * Every parameter representing time is in milliseconds.
 *
 * @param token Access token to be used on every api call.
 * @param createdIn Time when the token was generated.
 * @param expiresIn Time before token is invalidated.
 * @param userId User id in vkontakte.
 */
data class AccessInfo(
  val token: String,
  val createdIn: Long,
  val expiresIn: Long,
  val userId: Int
)