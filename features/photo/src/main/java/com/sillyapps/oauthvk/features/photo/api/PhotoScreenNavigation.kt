package com.sillyapps.oauthvk.features.photo.api

import androidx.compose.runtime.Composable
import com.sillyapps.core.ui.daggerViewModel
import com.sillyapps.oauthvk.domain.vk.di.VkComponent
import com.sillyapps.oauthvk.features.photo.di.DaggerPhotoScreenComponent
import com.sillyapps.oauthvk.features.photo.ui.PhotoScreen

@Composable
fun PhotoScreenNavigation(
  vkComponent: VkComponent,
  photoId: String?
) {

  val component = DaggerPhotoScreenComponent.builder()
    .vkComponent(vkComponent)
    .photoId(photoId)
    .build()

  val viewModel = daggerViewModel {
    component.getViewModel()
  }

  PhotoScreen(
    stateHolder = viewModel
  )

}