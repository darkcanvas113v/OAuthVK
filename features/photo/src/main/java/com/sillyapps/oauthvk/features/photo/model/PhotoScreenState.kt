package com.sillyapps.oauthvk.features.photo.model

sealed class PhotoScreenState() {

  object Loading: PhotoScreenState()

  class Default(val photo: PhotoUIModel): PhotoScreenState()

  class Error(val message: String): PhotoScreenState()

}
