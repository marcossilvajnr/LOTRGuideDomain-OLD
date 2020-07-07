package br.com.marcossilvajnr.lotr.guide.framework.api

import br.com.marcossilvajnr.lotr.guide.data.datasource.BookDataSource
import br.com.marcossilvajnr.lotr.guide.data.models.BooksBaseResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class BookApi(
    private val client: HttpClient
): BookDataSource {

    override suspend fun getAllBooks() = client.get<BooksBaseResponseModel>() {
        url { encodedPath = "/v1/book" }
    }
}