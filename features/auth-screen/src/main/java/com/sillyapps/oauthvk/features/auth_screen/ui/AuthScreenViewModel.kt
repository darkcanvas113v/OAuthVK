package com.sillyapps.oauthvk.features.auth_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sillyapps.core.di.ScreenScope
import com.sillyapps.oauthvk.domain.auth.model.AccessInfoState
import com.sillyapps.oauthvk.domain.auth.usecases.GetAccessTokenStateUseCase
import com.sillyapps.oauthvk.domain.auth.usecases.GetAccessTokenUseCase
import com.sillyapps.oauthvk.domain.auth.usecases.GetAuthPageUrlUseCase
import com.sillyapps.oauthvk.features.auth_screen.R
import com.sillyapps.oauthvk.features.auth_screen.model.AuthScreenState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ScreenScope
class AuthScreenViewModel @Inject constructor(
  private val getAuthPageUrlUseCase: GetAuthPageUrlUseCase,
  private val getAccessTokenStateUseCase: GetAccessTokenStateUseCase,
  private val getAccessTokenUseCase: GetAccessTokenUseCase
): ViewModel(), AuthScreenStateHolder {

  private val state = MutableStateFlow<AuthScreenState>(AuthScreenState.Loading)

  init {
    viewModelScope.launch {
      val accessToken = getAccessTokenUseCase()

      if (accessToken == null) {
        authorize()
      }

      observeAccessTokenState()
    }
  }

  private suspend fun observeAccessTokenState() {
    getAccessTokenStateUseCase().collect {
      if (it is AccessInfoState.Valid) {
        state.value = AuthScreenState.Authorized
      }
    }
  }

  private suspend fun authorize() {
    val url = getAuthPageUrlUseCase()

    if (url.isNotBlank()) {
      state.value = AuthScreenState.Authorizing(url)
    }
    else {
      state.value = AuthScreenState.Error(R.string.url_is_not_valid)
    }
  }

  override fun getState(): Flow<AuthScreenState> = state

}