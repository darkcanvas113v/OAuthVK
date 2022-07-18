package com.sillyapps.oauthvk.domain.auth.di

import com.sillyapps.oauthvk.domain.auth.AuthRepository
import com.sillyapps.oauthvk.domain.auth.usecases.*
import dagger.BindsInstance
import dagger.Component

@Component
interface AuthComponent {

  fun getAccessTokenUseCase(): GetAccessTokenUseCase

  fun getAuthPageUrlUseCase(): GetAuthPageUrlUseCase

  fun saveAccessInfoUseCase(): SaveAccessInfoUseCase

  fun getAccessTokenStateUseCase(): GetAccessTokenStateUseCase

  fun forgetAccessTokenUseCase(): ForgetAccessTokenUseCase

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun authRepository(repo: AuthRepository): Builder

    fun build(): AuthComponent

  }

}