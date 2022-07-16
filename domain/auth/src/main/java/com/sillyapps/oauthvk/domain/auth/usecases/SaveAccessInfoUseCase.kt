package com.sillyapps.oauthvk.domain.auth.usecases

import com.sillyapps.oauthvk.domain.auth.AuthRepository
import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import javax.inject.Inject

class SaveAccessInfoUseCase @Inject constructor(
  private val repository: AuthRepository
) {

  operator fun invoke(response: String) {
    repository.saveAccessInformation(response)
  }

}