package com.sillyapps.oauthvk.di

import android.content.Context
import android.content.SharedPreferences
import com.sillyapps.core.di.AppScope
import dagger.Module
import dagger.Provides

@Module
object PersistenceModule {
  @AppScope
  @Provides
  fun provideSharedPref(context: Context): SharedPreferences {
    return context.getSharedPreferences(SharedPref.TAG, Context.MODE_PRIVATE)
  }
}

object SharedPref {
  const val TAG = "OAuthVKSharedPreferences"
}