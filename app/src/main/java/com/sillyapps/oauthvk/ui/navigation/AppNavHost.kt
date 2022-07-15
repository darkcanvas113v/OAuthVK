package com.sillyapps.oauthvk.ui.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sillyapps.oauthvk.domain.auth.di.AuthComponent
import com.sillyapps.oauthvk.domain.auth.model.AccessInfoState
import com.sillyapps.oauthvk.features.auth_screen.api.AuthScreenNavigation

@Composable
fun AppNavHost(
  navController: NavHostController,
  authComponent: AuthComponent
) {

  val accessInfoState by remember {
    authComponent.getRepository().getAccessInfoState()
  }.collectAsState(initial = AccessInfoState.Invalid)

  val startDestination = when (accessInfoState) {
    is AccessInfoState.Valid -> Screen.AlbumScreen.route
    is AccessInfoState.Invalid -> Screen.AuthScreen.route
  }

  NavHost(
    navController = navController,
    startDestination = startDestination) {

    composable(route = Screen.AuthScreen.route) {
      AuthScreenNavigation(
        authComponent = authComponent
      )
    }

    composable(route = Screen.AlbumScreen.route) {
      Text(text = "Success!")
    }

    composable(route = Screen.PictureScreen.route) {

    }

  }

}