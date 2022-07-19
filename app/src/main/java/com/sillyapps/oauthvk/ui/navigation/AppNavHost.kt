package com.sillyapps.oauthvk.ui.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sillyapps.core.ui.util.navigateToTopDestination
import com.sillyapps.oauthvk.domain.auth.di.AuthComponent
import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import com.sillyapps.oauthvk.domain.auth.model.AccessInfoState
import com.sillyapps.oauthvk.domain.vk.di.VkComponent
import com.sillyapps.oauthvk.features.album.api.AlbumScreenNavigation
import com.sillyapps.oauthvk.features.auth_screen.api.AuthScreenNavigation
import com.sillyapps.oauthvk.features.photo.api.PhotoScreenNavigation
import com.sillyapps.oauthvk.ui.SplashScreen
import kotlinx.coroutines.launch

@Composable
fun AppNavHost(
  navController: NavHostController,
  authComponent: AuthComponent,
  vkComponent: VkComponent
) {

  NavHost(
    navController = navController,
    startDestination = Screen.AuthScreen.route
  ) {
    composable(route = Screen.AuthScreen.route) {
      AuthScreenNavigation(
        authComponent = authComponent,
        onAuthorized = {
          navController.navigateToTopDestination(
            route = Screen.AlbumScreen.route,
          )
        }
      )
    }

    composable(route = Screen.AlbumScreen.route) {
      AlbumScreenNavigation(
        onItemClick = {
          navController.navigate(
            route = "${Screen.PictureScreen.route}/$it"
          )
        },
        vkComponent = vkComponent,
        authComponent = authComponent,
        onLogoutButtonClick = {
          navController.navigateToTopDestination(
            route = Screen.AuthScreen.route,
          )
        }
      )
    }

    composable(
      route = "${Screen.PictureScreen.route}/{photoId}",
      arguments = listOf(navArgument("photoId") {
        type = NavType.StringType
      })
    ) { entry ->
      val photoId = entry.arguments?.getString("photoId")

      PhotoScreenNavigation(
        vkComponent = vkComponent,
        photoId = photoId
      )
    }

  }

}