package com.sillyapps.oauthvk.features.photo.ui

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sillyapps.core.util.model.Resource
import com.sillyapps.oauthvk.domain.vk.usecases.GetPhotoByIdUseCase
import com.sillyapps.oauthvk.features.photo.model.PhotoScreenState
import com.sillyapps.oauthvk.features.photo.model.toUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoScreenViewModel @Inject constructor(
  private val getPhotoByIdUseCase: GetPhotoByIdUseCase,
  private val photoId: String?
): ViewModel(), PhotoScreenStateHolder {

  private val mState = MutableStateFlow<PhotoScreenState>(PhotoScreenState.Loading)

  private var imageCache: Resource<Bitmap> = Resource.Loading()

  init {
    viewModelScope.launch {
      if (photoId == null) {
        mState.value = PhotoScreenState.Error("Photo id is null!")
        return@launch
      }

      val photoRes = getPhotoByIdUseCase(photoId)

      mState.value = when (photoRes) {
        is Resource.Error -> {
          PhotoScreenState.Error(photoRes.message)
        }
        is Resource.Loading -> {
          PhotoScreenState.Loading
        }
        is Resource.Success -> {
          PhotoScreenState.Default(photo = photoRes.data.toUIModel())
        }
      }
    }
  }

  override fun getState(): Flow<PhotoScreenState> {
    return mState
  }

  override fun saveBitmap(bitmap: Bitmap?) {
    imageCache = if (bitmap != null)
      Resource.Success(bitmap)
    else
      Resource.Error("Failed to load image")
  }

  override fun getBitMap(): Resource<Bitmap> {
    return imageCache
  }


}