package com.sillyapps.oauthvk.features.photo.ui

import android.provider.MediaStore
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.sillyapps.core.ui.components.ShowToast
import com.sillyapps.core.ui.components.showToast
import com.sillyapps.core.util.model.Resource
import com.sillyapps.oauthvk.features.photo.model.PhotoScreenState
import com.sillyapps.oauthvk.features.photo.ui.subscreens.DefaultScreen
import com.sillyapps.oauthvk.features.photo.ui.subscreens.ErrorScreen
import com.sillyapps.oauthvk.features.photo.ui.subscreens.LoadingScreen
import com.sillyapps.oauthvk.features.photo.util.shareImage

@Composable
fun PhotoScreen(
  stateHolder: PhotoScreenStateHolder
) {

  val mState by remember(stateHolder) {
    stateHolder.getState()
  }.collectAsState(initial = PhotoScreenState.Loading)

  val context = LocalContext.current

  Surface {
    Box(modifier = Modifier.fillMaxSize()) {
      when (val state = mState) {
        is PhotoScreenState.Default -> {
          DefaultScreen(
            photo = state.photo,
            onCacheImage = { stateHolder.saveBitmap(it) }
          )
        }
        is PhotoScreenState.Error -> {
          ErrorScreen()
          stateHolder.saveBitmap(null)
          ShowToast(message = state.message)
        }
        PhotoScreenState.Loading -> {
          LoadingScreen()
        }
      }

      FloatingActionButton(
        onClick = {
          when (val state = stateHolder.getBitMap()) {
            is Resource.Error -> {
              showToast(context = context, message = "Image couldn't be loaded")
            }
            is Resource.Loading -> {
              showToast(context = context, message = "Image is loading, please wait")
            }
            is Resource.Success -> {
              shareImage(state.data, context)
            }
          }
        },
        modifier = Modifier
          .align(Alignment.BottomEnd)
          .padding(16.dp)
      ) {
        Icon(imageVector = Icons.Filled.Share, contentDescription = null)
      }
    }
  }

}