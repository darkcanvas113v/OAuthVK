package com.sillyapps.oauthvk.features.auth_screen.ui

import android.webkit.*
import com.sillyapps.oauthvk.data.auth.AuthConstants
import com.sillyapps.oauthvk.domain.auth.usecases.SaveAccessInfoUseCase
import javax.inject.Inject

class AuthScreenWebViewClient @Inject constructor(
  private val saveAccessInfoUseCase: SaveAccessInfoUseCase
): WebViewClient() {

  override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
    if (url != null && url.startsWith(AuthConstants.SUCCESS_URL)) {
      saveAccessInfoUseCase(response = url)
    }

    super.doUpdateVisitedHistory(view, url, isReload)
  }

}