package com.example.newsapiclient.domain.repository

import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewRepository {
    suspend fun getNewsHeadlines(): Resource<APIResponse>

    suspend fun getSearchedNews(searQuery: String): Resource<APIResponse>

    suspend fun saveNews(article: Article)

    suspend fun deleteNews(article: Article)

    fun getSavedArticule(): Flow<List<Article>>
}