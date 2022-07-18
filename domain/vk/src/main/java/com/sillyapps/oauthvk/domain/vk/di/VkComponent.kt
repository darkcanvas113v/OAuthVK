package com.sillyapps.oauthvk.domain.vk.di

import com.sillyapps.oauthvk.domain.vk.VkRepository
import dagger.BindsInstance
import dagger.Component

@Component
interface VkComponent {

  fun getVkRepository(): VkRepository

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun vkRepository(repository: VkRepository): Builder

    fun build(): VkComponent
  }

}