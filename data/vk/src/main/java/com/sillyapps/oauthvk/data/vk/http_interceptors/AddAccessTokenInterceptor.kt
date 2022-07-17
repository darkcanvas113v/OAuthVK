package com.sillyapps.oauthvk.data.vk.http_interceptors

import com.sillyapps.oauthvk.data.vk.AccessTokenProvider
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AddAccessTokenInterceptor @Inject constructor(
  private val accessTokenProvider: AccessTokenProvider
) : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()

    val url = originalRequest.url.newBuilder().addQueryParameter(
      name = "access_token",
      value = accessTokenProvider.provideAccessToken()
    ).build()

    val requestWithAccessToken = originalRequest.newBuilder().url(url).build()

    return chain.proceed(requestWithAccessToken)
  }

}