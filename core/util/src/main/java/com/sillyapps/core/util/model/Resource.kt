package com.sillyapps.core.util.model

sealed class Resource<T> {
  class Initial<T>: Resource<T>()

  class Loading<T>: Resource<T>()

  class Success<T>(val data: T): Resource<T>()

  class Error<T>(val message: String): Resource<T>()
}
