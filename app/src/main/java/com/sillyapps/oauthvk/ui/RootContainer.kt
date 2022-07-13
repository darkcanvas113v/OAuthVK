package com.sillyapps.oauthvk.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.sillyapps.oauthvk.common.ui.theme.OAuthVKTheme
import com.sillyapps.oauthvk.ui.navigation.AppNavHost

@Composable
fun RootContainer(
) {
  val navHostController = rememberNavController()

  OAuthVKTheme {
    AppNavHost(
      navController = navHostController
    )
  }
}