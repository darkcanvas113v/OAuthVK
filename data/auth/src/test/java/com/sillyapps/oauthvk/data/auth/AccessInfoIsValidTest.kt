package com.sillyapps.oauthvk.data.auth

import com.sillyapps.oauthvk.data.auth.model.AccessInfoDataModel
import com.sillyapps.oauthvk.data.auth.model.isValid
import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import org.junit.Test

class AccessInfoIsValidTest {

  private val day = 86400L * 1000L

  @Test
  fun test_function_then_everything_is_correct() {
    val accessInfo = AccessInfoDataModel(
      token = "someToken",
      createdIn = System.currentTimeMillis() - (day * 0.5).toLong(),
      expiresIn = day,
      userId = 1
    )

    val isAccessInfoValid = accessInfo.isValid()

    assert(isAccessInfoValid)
  }

  @Test
  fun test_function_then_token_is_not_correct() {
    val accessInfo = AccessInfoDataModel(
      token = " ",
      createdIn = System.currentTimeMillis() - (day * 0.5).toLong(),
      expiresIn = day,
      userId = 1
    )

    val isAccessInfoValid = accessInfo.isValid()

    assert(!isAccessInfoValid)
  }

  @Test
  fun test_function_then_token_is_expired() {
    val accessInfo = AccessInfoDataModel(
      token = " ",
      createdIn = System.currentTimeMillis() - day * 2,
      expiresIn = day,
      userId = 1
    )

    val isAccessInfoValid = accessInfo.isValid()

    assert(!isAccessInfoValid)
  }

}