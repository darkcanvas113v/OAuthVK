package com.sillyapps.oauthvk.domain.auth.model

sealed class AccessInfoState() {

  object Invalid: AccessInfoState()

  object Valid: AccessInfoState()

}
