package br.com.marcossilvajnr.lotr.guide.domain.usercase

interface BaseUseCase<T> {
    suspend fun invoke():T
}