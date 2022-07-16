package com.sillyapps.oauthvk.data.auth.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.oauthvk.data.auth.AuthRepositoryImpl
import com.sillyapps.oauthvk.data.auth.datasources.accessinfo.AccessInfoDataSource
import com.sillyapps.oauthvk.data.auth.datasources.accessinfo.AccessInfoDataSourceImpl
import com.sillyapps.oauthvk.data.auth.datasources.authurl.AuthUrlDataSource
import com.sillyapps.oauthvk.data.auth.datasources.authurl.AuthUrlDataSourceImpl
import com.sillyapps.oauthvk.domain.auth.AuthRepository
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {

  @AppScope
  @Binds
  fun bindAccessInfoDataSource(dataSource: AccessInfoDataSourceImpl): AccessInfoDataSource

  @AppScope
  @Binds
  fun bindAuthUrlDataSource(dataSource: AuthUrlDataSourceImpl): AuthUrlDataSource

}