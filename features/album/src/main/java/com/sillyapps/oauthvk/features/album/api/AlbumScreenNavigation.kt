package com.sillyapps.oauthvk.features.album.api

import androidx.compose.runtime.Composable
import com.sillyapps.core.ui.daggerViewModel
import com.sillyapps.oauthvk.domain.vk.di.VkComponent
import com.sillyapps.oauthvk.features.album.di.DaggerAlbumScreenComponent
import com.sillyapps.oauthvk.features.album.ui.AlbumScreen

@Composable
fun AlbumScreenNavigation(
  onItemClick: (Int) -> Unit,
  vkComponent: VkComponent
) {

  val component = DaggerAlbumScreenComponent.builder()
    .vkComponent(vkComponent)
    .build()

  val viewModel = daggerViewModel {
    component.getViewModel()
  }

  AlbumScreen(
    stateHolder = viewModel,
    onItemClick = onItemClick
  )

}