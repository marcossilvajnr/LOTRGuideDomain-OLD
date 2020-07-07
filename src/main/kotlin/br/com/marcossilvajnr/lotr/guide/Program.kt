package br.com.marcossilvajnr.lotr.guide

import br.com.marcossilvajnr.lotr.guide.data.models.BookResponseModel
import br.com.marcossilvajnr.lotr.guide.data.models.CharacterResponseModel
import br.com.marcossilvajnr.lotr.guide.data.models.MovieResponseModel
import br.com.marcossilvajnr.lotr.guide.data.repository.BookRepository
import br.com.marcossilvajnr.lotr.guide.data.repository.CharacterRepository
import br.com.marcossilvajnr.lotr.guide.data.repository.MovieRepository
import br.com.marcossilvajnr.lotr.guide.framework.api.BookApi
import br.com.marcossilvajnr.lotr.guide.framework.api.CharacterApi
import br.com.marcossilvajnr.lotr.guide.framework.api.MovieApi
import br.com.marcossilvajnr.lotr.guide.framework.base.defaultCIOHttpClient
import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.runBlocking

@KtorExperimentalAPI
fun main() = runBlocking {
    try {
        println("start requests...")

        val books = getBooks()
        val movies = getMovies()
        val characters = getCharacters()

        println("finish...")
    } catch (exception: Exception) {
        print(exception.message)
    }
}

suspend fun getBooks(): List<BookResponseModel>? {
    val booksApi = BookApi(defaultCIOHttpClient)
    val booksRepository = BookRepository(booksApi)
    return booksRepository.getAllBooks().docs
}

suspend fun getMovies(): List<MovieResponseModel>? {
    val moviesApi = MovieApi(defaultCIOHttpClient)
    val moviesRepository = MovieRepository(moviesApi)
    return moviesRepository.getAllMovies().docs
}

suspend fun getCharacters(): List<CharacterResponseModel>? {
    val characterApi =
        CharacterApi(defaultCIOHttpClient)
    val characterRepository = CharacterRepository(characterApi)
    return characterRepository.getAllCharacters().docs
}