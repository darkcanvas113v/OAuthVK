package com.sillyapps.oauthvk.features.album.di

import com.sillyapps.oauthvk.domain.auth.di.AuthComponent
import com.sillyapps.oauthvk.domain.vk.di.VkComponent
import com.sillyapps.oauthvk.features.album.ui.AlbumScreenViewModel
import dagger.Component

@Component(dependencies = [VkComponent::class, AuthComponent::class])
interface AlbumScreenComponent {

  fun getViewModel(): AlbumScreenViewModel

  @Component.Builder
  interface Builder {

    fun vkComponent(vkComponent: VkComponent): Builder

    fun authComponent(authComponent: AuthComponent): Builder

    fun build(): AlbumScreenComponent
  }

}