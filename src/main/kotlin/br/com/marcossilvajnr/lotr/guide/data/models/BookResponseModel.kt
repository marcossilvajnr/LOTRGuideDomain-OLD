package br.com.marcossilvajnr.lotr.guide.data.models

open class BooksBaseResponseModel: BaseResponseModel<List<BookResponseModel>>()

data class BookResponseModel(
    val _id: String,
    val name: String
)