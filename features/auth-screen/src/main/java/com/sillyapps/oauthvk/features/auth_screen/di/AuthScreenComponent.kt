package com.sillyapps.oauthvk.features.auth_screen.di

import com.sillyapps.core.di.ScreenScope
import com.sillyapps.oauthvk.domain.auth.di.AuthComponent
import com.sillyapps.oauthvk.features.auth_screen.ui.AuthScreenViewModel
import com.sillyapps.oauthvk.features.auth_screen.ui.AuthScreenWebViewClient
import dagger.Component

@ScreenScope
@Component(dependencies = [AuthComponent::class])
interface AuthScreenComponent {

  fun getAuthScreenWebViewClient(): AuthScreenWebViewClient

  fun getViewModel(): AuthScreenViewModel

  @Component.Builder
  interface Builder {

    fun authComponent(component: AuthComponent): Builder

    fun build(): AuthScreenComponent

  }

}