package com.sillyapps.oauthvk.data.vk.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.oauthvk.data.vk.VkRepositoryImpl
import com.sillyapps.oauthvk.domain.vk.VkRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

  @AppScope
  @Binds
  fun bindRepository(vkRepositoryImpl: VkRepositoryImpl): VkRepository

}