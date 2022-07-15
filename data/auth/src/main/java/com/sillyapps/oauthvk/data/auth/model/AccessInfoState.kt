package com.sillyapps.oauthvk.data.auth.model

sealed class AccessInfoState() {

  object Invalid: AccessInfoState()

  object Valid: AccessInfoState()

}
