package com.sillyapps.oauthvk.features.photo.di

import com.sillyapps.core.di.ScreenScope
import com.sillyapps.oauthvk.domain.vk.di.VkComponent
import com.sillyapps.oauthvk.features.photo.ui.PhotoScreenViewModel
import dagger.BindsInstance
import dagger.Component

@ScreenScope
@Component(dependencies = [VkComponent::class])
interface PhotoScreenComponent {

  fun getViewModel(): PhotoScreenViewModel

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun photoId(id: String?): Builder

    fun vkComponent(vkComponent: VkComponent): Builder

    fun build(): PhotoScreenComponent

  }

}