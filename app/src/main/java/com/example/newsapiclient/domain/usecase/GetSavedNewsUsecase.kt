package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.repository.NewRepository

interface GetSavedNewsUseCase {

}

class GetSavedNewsUseCaseImpl(private val repository: NewRepository): GetSavedNewsUseCase {

}