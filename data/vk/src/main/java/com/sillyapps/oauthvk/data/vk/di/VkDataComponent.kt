package com.sillyapps.oauthvk.data.vk.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.core.di.IOCoroutineScope
import com.sillyapps.core.di.IOModule
import com.sillyapps.oauthvk.data.vk.AccessTokenProvider
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineScope

@AppScope
@Component(modules = [VkApiModule::class, IOModule::class])
interface VkDataComponent {

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun ioScope(@IOCoroutineScope ioScope: CoroutineScope): Builder

    @BindsInstance
    fun accessTokenProvider(accessTokenProvider: AccessTokenProvider): Builder

    fun build(): VkDataComponent
  }

}