package com.sillyapps.oauthvk.features.album.ui.subscreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sillyapps.oauthvk.common.ui.theme.OAuthVKTheme
import com.sillyapps.oauthvk.domain.vk.models.Photo
import com.sillyapps.oauthvk.features.album.ui.components.PhotoItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DefaultScreen(
  items: List<Photo>,
  onItemClick: (String) -> Unit
) {

  LazyVerticalGrid(
    modifier = Modifier.fillMaxSize(),
    cells = GridCells.Fixed(count = 2)
  ) {
    items(items = items) { photo ->
      PhotoItem(
        photo = photo,
        onClick = onItemClick
      )
    }
  }

}

@Preview
@Composable
fun DefaultSubScreenPreview() {
  OAuthVKTheme {
    DefaultScreen(
      items = listOf(
        Photo(0, 0, "", 0),
        Photo(0, 0, "", 0),
        Photo(0, 0, "", 0),
        Photo(0, 0, "", 0),
        Photo(0, 0, "", 0),
      ),
      onItemClick = {  }
    )
  }
}