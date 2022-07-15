package com.sillyapps.oauthvk.domain.auth.model

data class AccessInfo(
  val token: String,
  val expiresIn: Long,
  val userId: Int
)