package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.data.util.Resource
import com.example.newsapiclient.domain.repository.NewRepository
import kotlinx.coroutines.flow.Flow

interface GetNewsHeadlinesUseCase {
    suspend operator fun invoke(contry: String, page: Int): Resource<APIResponse>
}

class GetNewsHeadlinesUseCaseImpl(private val respository: NewRepository) : GetNewsHeadlinesUseCase {
    override suspend fun invoke(contry: String, page: Int): Resource<APIResponse> =
        respository.getNewsHeadlines(contry, page)
}