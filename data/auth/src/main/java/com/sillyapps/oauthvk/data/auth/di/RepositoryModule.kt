package com.sillyapps.oauthvk.data.auth.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.oauthvk.data.auth.AuthRepositoryImpl
import com.sillyapps.oauthvk.domain.auth.AuthRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

  @AppScope
  @Binds
  fun bindAuthRepository(repositoryImpl: AuthRepositoryImpl): AuthRepository

}