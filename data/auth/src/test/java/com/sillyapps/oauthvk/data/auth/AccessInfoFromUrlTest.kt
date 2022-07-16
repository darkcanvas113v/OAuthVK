package com.sillyapps.oauthvk.data.auth

import com.sillyapps.oauthvk.data.auth.datasources.accessinfo.AccessInfoDataSourceImpl.Companion.accessInfoFromUrl
import com.sillyapps.oauthvk.data.auth.model.AccessInfoDataModel
import com.sillyapps.oauthvk.domain.auth.model.AccessInfo
import org.junit.Test

class AccessInfoFromUrlTest {

  @Test
  fun accessInfoFromUrlIsCorrect() {
    val url = "https://oauth.vk.com/blank.html#access_token=vk1.a.cWaiHD6zi508wOxFRZVri5Ldt2JZ20ykXSgv2wVxCKC_C5KYY68wSHoV_Tc-ZQir-ggJ6_8y0ac3asUPpWzEU1DGB6HZsKr13kcEf5oirTCeHW5taqBzG9xWfI2bao_w8nV9ziExvSGXIfPgcvPgIfg9AjZmbjT_HGu9l1m1Z-jJ74YeiL4udz6ACx6TS8hB&expires_in=86400&user_id=473435272"

    val expected = AccessInfoDataModel(
      token = "vk1.a.cWaiHD6zi508wOxFRZVri5Ldt2JZ20ykXSgv2wVxCKC_C5KYY68wSHoV_Tc-ZQir-ggJ6_8y0ac3asUPpWzEU1DGB6HZsKr13kcEf5oirTCeHW5taqBzG9xWfI2bao_w8nV9ziExvSGXIfPgcvPgIfg9AjZmbjT_HGu9l1m1Z-jJ74YeiL4udz6ACx6TS8hB",
      userId = 473435272,
      expiresIn = 86400
    )
    val result = accessInfoFromUrl(url)

    assert(result == expected)
  }

}