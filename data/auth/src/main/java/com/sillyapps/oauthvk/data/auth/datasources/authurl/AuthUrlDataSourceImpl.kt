package com.sillyapps.oauthvk.data.auth.datasources.authurl

import javax.inject.Inject

class AuthUrlDataSourceImpl @Inject constructor() : AuthUrlDataSource {

  override fun getUrl(): String {
    return "https://oauth.vk.com/authorize?client_id=${API_ID}&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=token&v=5.131"
  }

  companion object {
    const val API_ID = 8217755
  }

}