package br.com.marcossilvajnr.lotr.guide.data.repository

import br.com.marcossilvajnr.lotr.guide.data.datasource.BookDataSource

class BookRepository(private val dataSource: BookDataSource) {
    suspend fun getAllBooks() = dataSource.getAllBooks()
}