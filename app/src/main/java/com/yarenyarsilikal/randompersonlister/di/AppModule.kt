package com.yarenyarsilikal.randompersonlister.di

import com.yarenyarsilikal.randompersonlister.data.local.datasource.LocalDataSource
import com.yarenyarsilikal.randompersonlister.data.repository.RepositoryImpl
import com.yarenyarsilikal.randompersonlister.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(): LocalDataSource = LocalDataSource()


    @Provides
    @Singleton
    fun provideRepository(localDataSource: LocalDataSource): Repository =
        RepositoryImpl(localDataSource)
}