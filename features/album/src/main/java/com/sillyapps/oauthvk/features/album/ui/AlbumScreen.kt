package com.sillyapps.oauthvk.features.album.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sillyapps.core.ui.components.ShowToast
import com.sillyapps.oauthvk.features.album.model.AlbumScreenState
import com.sillyapps.oauthvk.features.album.ui.subscreens.DefaultScreen
import com.sillyapps.oauthvk.features.album.ui.subscreens.LoadingScreen

@Composable
fun AlbumScreen(
  stateHolder: AlbumScreenStateHolder,
  onItemClick: (String) -> Unit,
  onLogoutButtonClick: () -> Unit
) {

  val mState by remember(stateHolder) {
    stateHolder.getState()
  }.collectAsState(initial = AlbumScreenState())

  Surface() {
    Box(
      modifier = Modifier.fillMaxSize()) {
      if (mState.isLoading) {
        LoadingScreen()
      }
      else {
        DefaultScreen(
          items = mState.photos,
          onItemClick = onItemClick
        )
      }

      FloatingActionButton(
        onClick = {
          stateHolder.logout()
          onLogoutButtonClick()
        },
        modifier = Modifier
          .align(Alignment.BottomEnd)
          .padding(16.dp)
      ) {
        Icon(imageVector = Icons.Filled.Logout, contentDescription = null)
      }
    }


    val errorMessage = mState.errorMessage

    if (errorMessage != null) {
      ShowToast(message = errorMessage)
    }
  }

}