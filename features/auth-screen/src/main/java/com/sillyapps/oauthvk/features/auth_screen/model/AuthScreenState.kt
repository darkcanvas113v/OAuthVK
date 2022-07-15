package com.sillyapps.oauthvk.features.auth_screen.model

sealed class AuthScreenState() {

  object Loading: AuthScreenState()

  class Default(val url: String): AuthScreenState()

  class Error(val messageResId: Int): AuthScreenState()

  object Success

}
