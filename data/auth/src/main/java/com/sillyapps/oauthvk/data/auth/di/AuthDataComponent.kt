package com.sillyapps.oauthvk.data.auth.di

import android.content.SharedPreferences
import com.sillyapps.core.di.AppScope
import com.sillyapps.core.di.IOModule
import com.sillyapps.oauthvk.domain.auth.AuthRepository
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineScope

@AppScope
@Component(modules = [IOModule::class, DataSourceModule::class, RepositoryModule::class])
interface AuthDataComponent {

  fun getAuthRepository(): AuthRepository

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun coroutineScope(scope: CoroutineScope): Builder

    @BindsInstance
    fun sharedPref(sharedPreferences: SharedPreferences): Builder

    fun build(): AuthDataComponent
  }

}