package com.sillyapps.oauthvk.features.photo.ui.subscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sillyapps.oauthvk.common.resources.R

@Composable
fun BoxScope.ErrorScreen() {
  Image(
    painter = painterResource(id = R.drawable.ic_baseline_broken_image_24),
    contentDescription = null,
    colorFilter = ColorFilter.tint(Color.Gray),
    contentScale = ContentScale.FillBounds,
    modifier = Modifier
      .align(Alignment.Center)
      .padding(16.dp)
  )
}