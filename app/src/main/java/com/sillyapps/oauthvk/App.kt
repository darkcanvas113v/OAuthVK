package com.sillyapps.oauthvk

import android.app.Application
import com.sillyapps.oauthvk.data.auth.di.DaggerAuthDataComponent
import com.sillyapps.oauthvk.di.DaggerAppComponent
import com.sillyapps.oauthvk.domain.auth.di.DaggerAuthComponent
import kotlinx.coroutines.MainScope

class App: Application() {

  private val appScope = MainScope()

  private val appComponent by lazy {
    DaggerAppComponent.builder()
      .context(applicationContext)
      .build()
  }

  val authDataComponent by lazy {
    DaggerAuthDataComponent.builder()
      .sharedPref(appComponent.getSharedPref())
      .coroutineScope(appScope)
      .build()
  }

  val authComponent by lazy {
    DaggerAuthComponent.builder()
      .authRepository(authDataComponent.getAuthRepository())
      .build()
  }

}