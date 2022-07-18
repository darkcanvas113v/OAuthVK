package com.sillyapps.oauthvk.ui.navigation

sealed class Screen(val route: String) {

  object AuthScreen: Screen(
    route = "auth_screen"
  )

  object AlbumScreen: Screen(
    route = "album_screen"
  )

  object PictureScreen: Screen(
    route = "picture_screen"
  )

  object SplashScreen: Screen(
    route = "splash_screen"
  )

}