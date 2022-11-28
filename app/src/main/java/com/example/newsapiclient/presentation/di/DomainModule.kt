package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.domain.repository.NewRepository
import com.example.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsapiclient.domain.usecase.GetNewsHeadlinesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideNewsHeadlinesUseCase(newRepository: NewRepository): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCaseImpl(newRepository)
    }
}