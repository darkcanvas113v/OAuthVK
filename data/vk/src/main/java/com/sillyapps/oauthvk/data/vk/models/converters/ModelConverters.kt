package com.sillyapps.oauthvk.data.vk.models.converters

import com.sillyapps.oauthvk.data.vk.models.getalbum.AlbumDto
import com.sillyapps.oauthvk.data.vk.models.getalbum.PhotoDto
import com.sillyapps.oauthvk.data.vk.models.getalbums.AlbumsDto
import com.sillyapps.oauthvk.domain.vk.models.Album
import com.sillyapps.oauthvk.domain.vk.models.AlbumItem
import com.sillyapps.oauthvk.domain.vk.models.Albums
import com.sillyapps.oauthvk.domain.vk.models.Photo

fun AlbumsDto.toDomainModel(): Albums {
  return Albums(
    list = albums.map { AlbumItem(id = it.id) }
  )
}

fun AlbumDto.toDomainModel(): Album {
  return Album(
    photos = photos.map {
      Photo(
        createdIn = it.date,
        url = it.sizes[0].url,
        id = it.id,
        ownerId = it.ownerId
      )
    }
  )
}

fun List<PhotoDto>.toDomainModel(): Photo {
  val photo = get(0)
  return Photo(
    createdIn = photo.date,
    url = photo.sizes[0].url,
    id = photo.id,
    ownerId = photo.ownerId
  )
}