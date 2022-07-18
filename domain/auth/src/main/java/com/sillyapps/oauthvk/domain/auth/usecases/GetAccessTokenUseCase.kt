package com.sillyapps.oauthvk.domain.auth.usecases

import com.sillyapps.oauthvk.domain.auth.AuthRepository
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
  private val repository: AuthRepository
) {

  operator fun invoke(): String? {
    val accessInfo = repository.getAccessInformation()

    return accessInfo?.token
  }

}