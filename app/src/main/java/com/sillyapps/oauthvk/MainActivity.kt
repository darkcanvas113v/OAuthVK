package com.sillyapps.oauthvk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sillyapps.oauthvk.ui.RootContainer

class MainActivity: ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val app = (application as App)

    setContent {
      RootContainer(authComponent = app.authComponent)
    }
  }

}