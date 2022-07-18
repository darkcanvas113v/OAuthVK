package com.sillyapps.oauthvk.data.vk.http_interceptors

import com.sillyapps.oauthvk.domain.auth.usecases.GetAccessTokenUseCase
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AddAccessTokenInterceptor @Inject constructor(
  private val getAccessTokenUseCase: GetAccessTokenUseCase
) : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()

    val url = originalRequest.url.newBuilder().addQueryParameter(
      name = "access_token",
      value = getAccessTokenUseCase()
    ).build()

    val requestWithAccessToken = originalRequest.newBuilder().url(url).build()

    return chain.proceed(requestWithAccessToken)
  }

}