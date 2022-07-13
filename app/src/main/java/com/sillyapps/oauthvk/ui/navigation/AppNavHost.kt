package com.sillyapps.oauthvk.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
  navController: NavHostController
) {

  NavHost(
    navController = navController,
    startDestination = Screen.AuthScreen.route) {

    composable(route = Screen.AuthScreen.route) {

    }

    composable(route = Screen.AlbumScreen.route) {

    }

    composable(route = Screen.PictureScreen.route) {

    }

  }

}