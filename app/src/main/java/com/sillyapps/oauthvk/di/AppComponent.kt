package com.sillyapps.oauthvk.di

import android.content.Context
import android.content.SharedPreferences
import com.sillyapps.core.di.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [PersistenceModule::class])
interface AppComponent {

  fun getSharedPref(): SharedPreferences

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun context(context: Context): Builder

    fun build(): AppComponent
  }

}