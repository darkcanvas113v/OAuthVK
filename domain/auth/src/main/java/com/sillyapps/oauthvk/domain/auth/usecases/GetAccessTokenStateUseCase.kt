package com.sillyapps.oauthvk.domain.auth.usecases

import com.sillyapps.oauthvk.domain.auth.AuthRepository
import javax.inject.Inject

class GetAccessTokenStateUseCase @Inject constructor(
  private val repository: AuthRepository
) {

  operator fun invoke() = repository.getAccessInfoState()

}