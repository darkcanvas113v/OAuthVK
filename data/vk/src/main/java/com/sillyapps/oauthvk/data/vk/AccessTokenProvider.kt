package com.sillyapps.oauthvk.data.vk

interface AccessTokenProvider {
  fun provideAccessToken(): String
}