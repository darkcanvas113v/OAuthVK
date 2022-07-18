package com.sillyapps.oauthvk.features.album.ui.subscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sillyapps.oauthvk.common.ui.theme.OAuthVKTheme
import com.sillyapps.oauthvk.features.album.R

@Composable
fun LoadingSubScreen() {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(
      text = stringResource(id = R.string.loading_from_server),
      textAlign = TextAlign.Center,
      style = MaterialTheme.typography.h5,
      modifier = Modifier.padding(16.dp)
    )
    CircularProgressIndicator()
  }
}

@Preview
@Composable
fun LoadingSubScreenPreview() {
  OAuthVKTheme {
    Surface {
      LoadingSubScreen()
    }
  }
}