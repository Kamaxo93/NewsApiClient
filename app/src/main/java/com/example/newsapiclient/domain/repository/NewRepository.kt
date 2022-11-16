package com.example.newsapiclient.domain.repository

import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.example.newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewRepository {
    suspend fun getNewsHeadlines(): Resource<APIResponse>

    suspend fun getSearchedNews(searQuery: String): Resource<APIResponse>

    suspend fun saveNews(article: Article)

    suspend fun deleteNews(article: Article)

    fun getSavedArticule(): Flow<List<Article>>
}

class NewRepositoryImpl(private val remoteDataSource: NewsRemoteDataSource) : NewRepository {

    override suspend fun getNewsHeadlines(): Resource<APIResponse> =
        responseToResource(remoteDataSource.getTopHeadlines())

    override suspend fun getSearchedNews(searQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedArticule(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
}