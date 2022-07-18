package com.sillyapps.oauthvk.features.album.ui.subscreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.oauthvk.common.ui.theme.OAuthVKTheme
import com.sillyapps.oauthvk.domain.vk.models.Photo
import com.sillyapps.oauthvk.features.album.ui.components.PhotoItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DefaultSubScreen(
  items: List<Photo>,
  onItemClick: (Int) -> Unit
) {

  LazyVerticalGrid(
    modifier = Modifier.fillMaxSize(),
    cells = GridCells.Fixed(count = 2)
  ) {
    itemsIndexed(items = items) { index, photo ->
      PhotoItem(
        photo = photo,
        onClick = { onItemClick(index) }
      )
    }
  }

}

@Preview
@Composable
fun DefaultSubScreenPreview() {
  OAuthVKTheme {
    DefaultSubScreen(
      items = listOf(
        Photo("", 0),
        Photo("", 0),
        Photo("", 0),
        Photo("", 0),
        Photo("", 0),
      ),
      onItemClick = {}
    )
  }
}