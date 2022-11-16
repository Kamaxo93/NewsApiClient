package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.data.util.Resource
import com.example.newsapiclient.domain.repository.NewRepository

interface GetSearchedNews {
    suspend operator fun invoke(searQuery: String): Resource<APIResponse>
}

class GetSearchedNewsImpl(private val repository: NewRepository) : GetSearchedNews {
    override suspend fun invoke(searQuery: String): Resource<APIResponse> =
        repository.getSearchedNews(searQuery)
}