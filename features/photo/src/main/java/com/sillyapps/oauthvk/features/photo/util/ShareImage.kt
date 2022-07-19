package com.sillyapps.oauthvk.features.photo.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

fun shareImage(bitmap: Bitmap, context: Context) {
  val uriPermissionFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION and Intent.FLAG_GRANT_WRITE_URI_PERMISSION

  val uri = getImageToShare(bitmap, context) ?: return

  val intent = Intent(Intent.ACTION_SEND)

  intent.setDataAndType(uri, "image/png")
  intent.putExtra(Intent.EXTRA_TEXT, "Sharing image")
  intent.putExtra(Intent.EXTRA_SUBJECT, "Subject here")
  intent.addFlags(uriPermissionFlags)

  context.grantUriPermission(context.packageName, uri, uriPermissionFlags)

  context.startActivity(Intent.createChooser(intent, "Share via"))
}

fun getImageToShare(bitmap: Bitmap, context: Context): Uri? {
  val imageFolder = File(context.cacheDir, "images")

  if (!hasWriteToStoragePermission(context)) {
    ActivityCompat.requestPermissions(context as Activity,
      arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)
    Log.d("", "Doesn't have permission to write")
    return null
  }

  return try {
    imageFolder.mkdirs()
    val file = File(imageFolder, "shared_image.png")
    val oStream = FileOutputStream(file)

    bitmap.compress(Bitmap.CompressFormat.PNG, 100, oStream)
    oStream.flush()
    oStream.close()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      FileProvider.getUriForFile(context, context.packageName, file)
    } else
      Uri.fromFile(file)
  } catch (e: Exception) {
    Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
    null
  }
}