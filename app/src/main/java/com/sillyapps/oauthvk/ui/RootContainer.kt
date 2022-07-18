package com.sillyapps.oauthvk.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.sillyapps.oauthvk.common.ui.theme.OAuthVKTheme
import com.sillyapps.oauthvk.domain.auth.di.AuthComponent
import com.sillyapps.oauthvk.domain.auth.di.DaggerAuthComponent
import com.sillyapps.oauthvk.domain.vk.di.VkComponent
import com.sillyapps.oauthvk.ui.navigation.AppNavHost

@Composable
fun RootContainer(
  authComponent: AuthComponent,
  vkComponent: VkComponent
) {
  val navHostController = rememberNavController()

  OAuthVKTheme {
    AppNavHost(
      navController = navHostController,
      authComponent = authComponent,
      vkComponent = vkComponent
    )
  }
}