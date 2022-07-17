package com.sillyapps.oauthvk.data.vk.http_interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AddApiVersionInterceptor @Inject constructor(): Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()

    val url = originalRequest.url.newBuilder().addQueryParameter("v", apiVersion).build()
    val requestWithApiVersion = originalRequest.newBuilder().url(url).build()

    return chain.proceed(requestWithApiVersion)
  }

  companion object {
    const val apiVersion = "5.131"
  }

}