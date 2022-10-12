package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.repository.NewRepository

interface SaveNewsUseCase {

}

class SaveNewsUseCaseImpl(private val repository: NewRepository): SaveNewsUseCase {

}