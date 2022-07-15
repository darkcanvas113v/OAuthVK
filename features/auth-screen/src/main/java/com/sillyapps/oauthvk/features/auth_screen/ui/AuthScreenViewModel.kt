package com.sillyapps.oauthvk.features.auth_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sillyapps.core.di.ScreenScope
import com.sillyapps.oauthvk.domain.auth.usecases.GetAuthPageUrlUseCase
import com.sillyapps.oauthvk.features.auth_screen.R
import com.sillyapps.oauthvk.features.auth_screen.model.AuthScreenState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ScreenScope
class AuthScreenViewModel @Inject constructor(
  private val getAuthPageUrlUseCase: GetAuthPageUrlUseCase
): ViewModel(), AuthScreenStateHolder {

  private val state = MutableStateFlow<AuthScreenState>(AuthScreenState.Loading)

  init {
    viewModelScope.launch {
      val url = getAuthPageUrlUseCase()

      if (url.isNotBlank()) {
        state.value = AuthScreenState.Default(url)
      }
      else {
        state.value = AuthScreenState.Error(R.string.url_is_not_valid)
      }

    }
  }

  override fun getState(): Flow<AuthScreenState> = state

}