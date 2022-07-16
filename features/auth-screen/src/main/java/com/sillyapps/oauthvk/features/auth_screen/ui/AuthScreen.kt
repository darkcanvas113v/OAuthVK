package com.sillyapps.oauthvk.features.auth_screen.ui

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.sillyapps.oauthvk.common.ui.theme.OAuthVKTheme
import com.sillyapps.oauthvk.features.auth_screen.model.AuthScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
fun AuthScreen(
  stateHolder: AuthScreenStateHolder,
  mWebViewClient: WebViewClient
) {

  val mState by remember(stateHolder) {
    stateHolder.getState()
  }.collectAsState(initial = AuthScreenState.Loading)

  when(val state = mState) {
    is AuthScreenState.Error -> {

    }
    is AuthScreenState.Loading -> {

    }
    is AuthScreenState.Default -> {
      AndroidView(
        factory = {
          WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT,
              ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = mWebViewClient
            loadUrl(state.url)
          }
        },
        update = {
          it.loadUrl(state.url)
        }
      )
    }
  }



}

@Preview
@Composable
fun AuthScreenPreview() {
  val url = "https://oauth.vk.com/authorize?client_id=8217755&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=token&v=5.131"

  val stateHolder = object : AuthScreenStateHolder {
    override fun getState(): Flow<AuthScreenState> = flow {
      emit(AuthScreenState.Default(url = url))
    }
  }

  OAuthVKTheme {
    AuthScreen(
      stateHolder,
      mWebViewClient = WebViewClient()
    )
  }
}