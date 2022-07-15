package com.sillyapps.oauthvk.domain.auth.usecases

import com.sillyapps.oauthvk.domain.auth.AuthRepository
import javax.inject.Inject

class GetAuthPageUrlUseCase @Inject constructor(
  private val repository: AuthRepository
) {

  suspend operator fun invoke() = repository.getAuthorizationPageUrl()

}