package com.sillyapps.oauthvk

import android.app.Application
import com.sillyapps.oauthvk.data.auth.di.DaggerAuthDataComponent
import com.sillyapps.oauthvk.data.vk.di.DaggerVkDataComponent
import com.sillyapps.oauthvk.di.DaggerAppComponent
import com.sillyapps.oauthvk.domain.auth.di.DaggerAuthComponent
import com.sillyapps.oauthvk.domain.vk.di.DaggerVkComponent
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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

  val vkDataComponent by lazy {
    DaggerVkDataComponent.builder()
      .authComponent(authComponent)
      .build()
  }

  val vkComponent by lazy {
    DaggerVkComponent.builder()
      .vkRepository(vkDataComponent.getRepository())
      .build()
  }

  override fun onCreate() {
    super.onCreate()
  }

}