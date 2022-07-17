package com.sillyapps.oauthvk.data.vk.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.oauthvk.data.vk.VkApi
import com.sillyapps.oauthvk.data.vk.http_interceptors.AddAccessTokenInterceptor
import com.sillyapps.oauthvk.data.vk.http_interceptors.AddApiVersionInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
object VkApiModule {

  @AppScope
  @Provides
  fun provideVkApi(client: OkHttpClient): VkApi {
    return Retrofit.Builder()
      .baseUrl("https://api.vk.com/")
      .client(client)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
      .create(VkApi::class.java)
  }

  @AppScope
  @Provides
  fun provideHttpClient(
    addApiVersionInterceptor: AddApiVersionInterceptor,
    addAccessTokenInterceptor: AddAccessTokenInterceptor
  ): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS

    return OkHttpClient.Builder()
      .addInterceptor(addApiVersionInterceptor)
      .addInterceptor(addAccessTokenInterceptor)
      .addInterceptor(loggingInterceptor)
      .build()
  }

}