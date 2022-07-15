package com.sillyapps.oauthvk.domain.auth.di

import com.sillyapps.oauthvk.domain.auth.AuthRepository
import dagger.BindsInstance
import dagger.Component

@Component
interface AuthComponent {

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun authRepository(repo: AuthRepository): Builder

    fun build(): AuthComponent

  }

}