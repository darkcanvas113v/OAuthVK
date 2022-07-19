package com.sillyapps.oauthvk.features.photo.ui.subscreens

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BoxScope.LoadingScreen() {

  CircularProgressIndicator(
    modifier = Modifier.align(alignment = Alignment.Center)
  )

}