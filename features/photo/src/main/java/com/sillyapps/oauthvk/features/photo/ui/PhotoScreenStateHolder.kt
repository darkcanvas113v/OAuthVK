package com.sillyapps.oauthvk.features.photo.ui

import android.graphics.Bitmap
import com.sillyapps.core.util.model.Resource
import com.sillyapps.oauthvk.features.photo.model.PhotoScreenState
import kotlinx.coroutines.flow.Flow

interface PhotoScreenStateHolder {

  fun getState(): Flow<PhotoScreenState>

  fun saveBitmap(bitmap: Bitmap?)

  fun getBitMap(): Resource<Bitmap>

}