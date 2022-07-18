package com.sillyapps.oauthvk.data.vk.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.core.di.IOModule
import com.sillyapps.oauthvk.domain.auth.di.AuthComponent
import com.sillyapps.oauthvk.domain.vk.VkRepository
import dagger.Component

@AppScope
@Component(
  modules = [VkApiModule::class, IOModule::class, RepositoryModule::class],
  dependencies = [AuthComponent::class]
)
interface VkDataComponent {

  fun getRepository(): VkRepository

  @Component.Builder
  interface Builder {

    fun authComponent(authComponent: AuthComponent): Builder

    fun build(): VkDataComponent
  }

}