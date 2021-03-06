package com.sillyapps.oauthvk.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SplashScreen() {
  Surface(
    modifier = Modifier.fillMaxSize()
  ) {
    Box(contentAlignment = Alignment.Center) {
      CircularProgressIndicator()
    }
  }
}