package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.domain.repository.NewRepository

interface DeleteNewsUseCase {
    suspend operator fun invoke(article: Article)
}

class DeleteNewsUseCaseImpl(private val repository: NewRepository) : DeleteNewsUseCase {
    override suspend fun invoke(article: Article) {
        repository.deleteNews(article)
    }
}