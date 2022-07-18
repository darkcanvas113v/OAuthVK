package com.sillyapps.oauthvk.domain.auth.di

import com.sillyapps.oauthvk.domain.auth.AuthRepository
import com.sillyapps.oauthvk.domain.auth.usecases.GetAccessTokenStateUseCase
import com.sillyapps.oauthvk.domain.auth.usecases.GetAccessTokenUseCase
import com.sillyapps.oauthvk.domain.auth.usecases.GetAuthPageUrlUseCase
import com.sillyapps.oauthvk.domain.auth.usecases.SaveAccessInfoUseCase
import dagger.BindsInstance
import dagger.Component

@Component
interface AuthComponent {

  fun getAccessTokenUseCase(): GetAccessTokenUseCase

  fun getAuthPageUrlUseCase(): GetAuthPageUrlUseCase

  fun saveAccessInfoUseCase(): SaveAccessInfoUseCase

  fun getAccessTokenStateUseCase(): GetAccessTokenStateUseCase

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun authRepository(repo: AuthRepository): Builder

    fun build(): AuthComponent

  }

}