package com.sillyapps.oauthvk.features.photo.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun hasWriteToStoragePermission(context: Context): Boolean {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
    return true
  } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    if (ContextCompat.checkSelfPermission(
        context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
      return false
    }
  }
  return true
}