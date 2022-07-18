package com.sillyapps.oauthvk.data.vk

import com.sillyapps.core.util.model.Resource
import com.sillyapps.core_network.retrofitErrorHandler
import com.sillyapps.oauthvk.data.vk.models.VkApiResponse
import com.sillyapps.oauthvk.data.vk.models.converters.toDomainModel
import com.sillyapps.oauthvk.domain.vk.VkRepository
import com.sillyapps.oauthvk.domain.vk.models.Albums
import kotlinx.coroutines.*
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class VkRepositoryImpl @Inject constructor(
  private val vkApi: VkApi,
  private val ioDispatcher: CoroutineDispatcher
) : VkRepository {

  override suspend fun getAlbums(): Resource<Albums> = withContext(ioDispatcher) {
    makeApiCall(
      apiResponse = vkApi.getAlbums(),
      modelConverter = { it.toDomainModel() }
    )
  }

  override suspend fun getAlbum(albumId: Int) = withContext(ioDispatcher) {
    makeApiCall(
      apiResponse = vkApi.getAlbum(albumId),
      modelConverter = { it.toDomainModel() }
    )
  }

  private fun <T, M> makeApiCall(
    apiResponse: Response<VkApiResponse<T>>,
    modelConverter: (T) -> M
  ): Resource<M> {
    return try {
      val response = retrofitErrorHandler(apiResponse)
      if (response.body != null)
        Resource.Success(data = modelConverter(response.body))
      else
        Resource.Error(response.error?.errorMessage ?: "Unknown error!")
    }
    catch (e: Exception) {
      Resource.Error(e.message ?: "Unknown error!")
    }
  }


}