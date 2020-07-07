package br.com.marcossilvajnr.lotr.guide.data.datasource

import br.com.marcossilvajnr.lotr.guide.data.models.BooksBaseResponseModel

interface BookDataSource {
    suspend fun getAllBooks(): BooksBaseResponseModel
}