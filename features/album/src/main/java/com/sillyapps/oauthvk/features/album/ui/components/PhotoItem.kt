package com.sillyapps.oauthvk.features.album.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.sillyapps.oauthvk.common.ui.theme.OAuthVKTheme
import com.sillyapps.oauthvk.domain.vk.models.Photo
import com.sillyapps.oauthvk.domain.vk.models.getStringId
import com.sillyapps.oauthvk.features.album.R
import com.skydoves.landscapist.glide.GlideImage
import com.sillyapps.oauthvk.common.resources.R as commonR

@Composable
fun PhotoItem(
  photo: Photo,
  onClick: (String) -> Unit
) {

  var isLoading by remember {
    mutableStateOf(true)
  }

  Surface(
    shape = MaterialTheme.shapes.small,
    modifier = Modifier.clickable {
      onClick(photo.getStringId())
    }.height(200.dp)
      .width(200.dp)
      .padding(4.dp),
    color = Color.LightGray
  ) {
    if (isLoading) {
      CircularProgressIndicator()
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
    )
  }
}

@Preview
@Composable
fun PhotoItemPreview() {
  OAuthVKTheme {
    PhotoItem(
      photo = Photo(url = "", createdIn = 0, id = 0, ownerId = 0),
      onClick = {  }
    )
  }
}