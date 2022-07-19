package com.sillyapps.oauthvk.domain.vk.usecases

import com.sillyapps.oauthvk.domain.vk.VkRepository
import com.sillyapps.oauthvk.domain.vk.models.Photo
import javax.inject.Inject

class GetPhotoByIdUseCase @Inject constructor(
  private val repository: VkRepository
) {

  suspend operator fun invoke(photoId: String) = repository.getPhotoById(photoId)

}