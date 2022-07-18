package com.sillyapps.oauthvk.ui.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sillyapps.oauthvk.domain.auth.di.AuthComponent
import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import com.sillyapps.oauthvk.domain.auth.model.AccessInfoState
import com.sillyapps.oauthvk.domain.vk.di.VkComponent
import com.sillyapps.oauthvk.features.album.api.AlbumScreenNavigation
import com.sillyapps.oauthvk.features.auth_screen.api.AuthScreenNavigation
import com.sillyapps.oauthvk.ui.SplashScreen
import kotlinx.coroutines.launch

@Composable
fun AppNavHost(
  navController: NavHostController,
  authComponent: AuthComponent,
  vkComponent: VkComponent
) {

  val accessInfoState by remember {
    authComponent.getAccessTokenStateUseCase().invoke()
  }.collectAsState(initial = AccessInfoState.Initial)

  NavHost(
    navController = navController,
    startDestination = Screen.SplashScreen.route) {

    composable(route = Screen.SplashScreen.route) {
      SplashScreen()
    }

    composable(route = Screen.AuthScreen.route) {
      AuthScreenNavigation(
        authComponent = authComponent
      )
    }

    composable(route = Screen.AlbumScreen.route) {
      AlbumScreenNavigation(
        onItemClick = {},
        vkComponent = vkComponent
      )
    }

    composable(route = Screen.PictureScreen.route) {

    }

  }

  when (accessInfoState) {
    is AccessInfoState.Invalid -> navController.navigate(route = Screen.AuthScreen.route)
    is AccessInfoState.Valid -> navController.navigate(route = Screen.AlbumScreen.route)
    else -> {}
  }

}