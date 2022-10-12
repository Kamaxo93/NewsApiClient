package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.repository.NewRepository

interface GetNewsHeadlinesUseCase {
    suspend operator fun invoke()
}

class GetNewsHeadlinesUseCaseImpl(private val respository: NewRepository) : GetNewsHeadlinesUseCase {

}