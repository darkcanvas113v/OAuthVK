package com.sillyapps.oauthvk.features.photo.ui.subscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.sillyapps.oauthvk.common.ui.theme.OAuthVKTheme
import com.sillyapps.oauthvk.domain.vk.models.Photo
import com.sillyapps.oauthvk.features.photo.model.PhotoUIModel
import com.sillyapps.oauthvk.common.resources.R as commonR
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun BoxScope.DefaultScreen(
  photo: PhotoUIModel
) {

  Text(
    text = photo.createdIn,
    style = MaterialTheme.typography.h5,
    modifier = Modifier
      .padding(16.dp)
      .align(Alignment.TopStart)
  )

  var isLoading by remember {
    mutableStateOf(true)
  }

  if (isLoading) {
    CircularProgressIndicator(
      modifier = Modifier.align(alignment = Alignment.Center)
    )
  }

  GlideImage(
    imageModel = photo.url,
    contentScale = ContentScale.FillBounds,
    alignment = Alignment.Center,
    success = { imageState ->
      val drawable = imageState.drawable

      if (drawable != null) {
        Image(
          bitmap = drawable.toBitmap().asImageBitmap(),
          contentDescription = null,
          modifier = Modifier.fillMaxSize()
        )
      }
      isLoading = false
    },
    failure = {
      Image(
        painter = painterResource(id = commonR.drawable.ic_baseline_broken_image_24),
        contentDescription = null,
        colorFilter = ColorFilter.tint(Color.Gray)
      )

      isLoading = false
    },
    previewPlaceholder = commonR.drawable.ic_baseline_broken_image_24,
    modifier = Modifier.fillMaxSize()
  )

}

@Preview
@Composable
fun DefaultScreenPreview() {
  OAuthVKTheme {
    Surface() {
      Box(modifier = Modifier.fillMaxSize()) {
        DefaultScreen(photo = PhotoUIModel("", "00:00:00", 0))
      }
    }
  }
}
