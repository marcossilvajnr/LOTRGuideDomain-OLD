package br.com.marcossilvajnr.lotr.guide.domain.mapper

import br.com.marcossilvajnr.lotr.guide.data.base.BaseLayerDataTransformer
import br.com.marcossilvajnr.lotr.guide.data.models.BookResponseModel
import br.com.marcossilvajnr.lotr.guide.domain.model.Book

class BookResponseMapperToBook: BaseLayerDataTransformer<BookResponseModel, Book>() {
    override fun transform(from: BookResponseModel): Book {
        return Book(
            id = from._id,
            name = from.name
        )
    }
}