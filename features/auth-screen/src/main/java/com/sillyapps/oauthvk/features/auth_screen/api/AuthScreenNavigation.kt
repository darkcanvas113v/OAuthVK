package com.sillyapps.oauthvk.features.auth_screen.api

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sillyapps.core.ui.daggerViewModel
import com.sillyapps.oauthvk.domain.auth.di.AuthComponent
import com.sillyapps.oauthvk.features.auth_screen.di.DaggerAuthScreenComponent
import com.sillyapps.oauthvk.features.auth_screen.ui.AuthScreen

@Composable
fun AuthScreenNavigation(
  authComponent: AuthComponent,
  onAuthorized: () -> Unit
) {

  val component = DaggerAuthScreenComponent.builder()
    .authComponent(authComponent)
    .build()

  val viewModel = daggerViewModel {
    component.getViewModel()
  }

  val webViewClient = component.getAuthScreenWebViewClient()

  AuthScreen(
    stateHolder = viewModel,
    mWebViewClient = webViewClient,
    onAuthorized = onAuthorized
  )

}