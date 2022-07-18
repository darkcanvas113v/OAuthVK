package com.sillyapps.oauthvk.features.album.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.sillyapps.core.ui.components.ShowToast
import com.sillyapps.oauthvk.features.album.model.AlbumScreenState
import com.sillyapps.oauthvk.features.album.ui.subscreens.DefaultSubScreen
import com.sillyapps.oauthvk.features.album.ui.subscreens.LoadingSubScreen
import com.sillyapps.oauthvk.features.album.ui.subscreens.LoadingSubScreenPreview

@Composable
fun AlbumScreen(
  stateHolder: AlbumScreenStateHolder,
  onItemClick: (Int) -> Unit
) {

  val mState by remember(stateHolder) {
    stateHolder.getState()
  }.collectAsState(initial = AlbumScreenState())

  Surface(
    modifier = Modifier.fillMaxSize()
  ) {
    if (mState.isLoading) {
      LoadingSubScreen()
    }
    else {
      DefaultSubScreen(
        items = mState.photos,
        onItemClick = onItemClick
      )
    }

    val errorMessage = mState.errorMessage

    if (errorMessage != null) {
      ShowToast(message = errorMessage)
    }
  }

}