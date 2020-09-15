package br.com.marcossilvajnr.lotr.guide.domain.usercase

import br.com.marcossilvajnr.lotr.guide.data.repository.BookRepository
import br.com.marcossilvajnr.lotr.guide.domain.mapper.BookResponseMapperToBook
import br.com.marcossilvajnr.lotr.guide.domain.model.Book

open class GetAllBooksUseCase constructor(
    private val repository: BookRepository,
    private val mapper: BookResponseMapperToBook
): BaseUseCase<List<Book>?> {
    override suspend fun invoke(): List<Book>? {
        return repository.getAllBooks().docs?.map(mapper::transform)
    }
}