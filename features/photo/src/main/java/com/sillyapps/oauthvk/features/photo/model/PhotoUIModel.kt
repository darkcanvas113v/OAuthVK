package com.sillyapps.oauthvk.features.photo.model

import android.annotation.SuppressLint
import com.sillyapps.oauthvk.domain.vk.models.Photo
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

data class PhotoUIModel(
  val url: String,
  val createdIn: String,
  val id: Int
)

fun Photo.toUIModel(): PhotoUIModel {
  val dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(createdIn), ZoneId.systemDefault())
  val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)

  return PhotoUIModel(
    url = url,
    createdIn = dateTime.format(formatter),
    id = id
  )
}