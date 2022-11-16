package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.domain.repository.NewRepository

interface GetSavedNewsUseCase {
    suspend operator fun invoke(article: Article)
}

class GetSavedNewsUseCaseImpl(private val repository: NewRepository): GetSavedNewsUseCase {
    override suspend fun invoke(article: Article) =
        repository.saveNews(article)
}