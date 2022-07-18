package com.sillyapps.oauthvk.domain.auth.usecases

import com.sillyapps.oauthvk.domain.auth.AuthRepository
import javax.inject.Inject

class ForgetAccessTokenUseCase @Inject constructor(
  private val repository: AuthRepository
) {

  operator fun invoke() {
    repository.forgetAccessInformation()
  }

}