package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.example.newsapiclient.domain.repository.NewRepository
import com.example.newsapiclient.domain.repository.NewRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ReposirtoryModule {

    @Singleton
    @Provides
    fun provieNewReopistory(remoteDataSource: NewsRemoteDataSource): NewRepository {
        return NewRepositoryImpl(remoteDataSource)
    }
}