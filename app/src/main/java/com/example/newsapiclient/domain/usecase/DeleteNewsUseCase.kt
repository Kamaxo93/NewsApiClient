package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.repository.NewRepository

interface DeleteNewsUseCase {

}

class DeleteNewsUseCaseImpl(private val repository: NewRepository) : DeleteNewsUseCase {

}