package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.domain.repository.NewRepository
import kotlinx.coroutines.flow.Flow

interface SaveNewsUseCase {
    operator fun invoke(): Flow<List<Article>>
}

class SaveNewsUseCaseImpl(private val repository: NewRepository): SaveNewsUseCase {
    override fun invoke(): Flow<List<Article>> =
        repository.getSavedArticule()
}