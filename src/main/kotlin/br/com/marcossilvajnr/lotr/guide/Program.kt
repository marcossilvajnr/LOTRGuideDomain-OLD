package br.com.marcossilvajnr.lotr.guide

import br.com.marcossilvajnr.lotr.guide.data.repository.BookRepository
import br.com.marcossilvajnr.lotr.guide.data.repository.CharacterRepository
import br.com.marcossilvajnr.lotr.guide.domain.mapper.*
import br.com.marcossilvajnr.lotr.guide.domain.model.*
import br.com.marcossilvajnr.lotr.guide.domain.usercase.*
import br.com.marcossilvajnr.lotr.guide.framework.api.BookApi
import br.com.marcossilvajnr.lotr.guide.framework.api.CharacterApi
import br.com.marcossilvajnr.lotr.guide.framework.base.defaultCIOHttpClient
import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {

}

@KtorExperimentalAPI
fun main() = runBlocking {
    try {
        println("start requests...")

        val characters = getCharacters()
        val races = getRaces()
        val genders = getGenders()
        val reals = getRealms()
        val books = getBooks()

        println("finish...")
    } catch (exception: Exception) {
        print(exception.message)
    }
}

@KtorExperimentalAPI
suspend fun getBooks(): List<Book>? {
    val api = BookApi(defaultCIOHttpClient)
    val repository = BookRepository(api)
    val mapper = BookResponseMapperToBook()
    val useCase = GetAllBooksUseCase(repository, mapper)
    return useCase.invoke()
}

@KtorExperimentalAPI
suspend fun getCharacters(): List<Character>? {
    val api = CharacterApi(defaultCIOHttpClient)
    val repository = CharacterRepository(api)
    val mapperRace = CharacterResponseToRaceMapper()
    val mapperGender = CharacterResponseToGenderMapper()
    val mapperReal = CharacterResponseToRealmMapper()
    val mapperCharacter = CharacterResponseToCharacterMapper(
        raceMapper = mapperRace,
        genderMapper = mapperGender,
        realmMapper = mapperReal
    )

    return GetAllCharactersUseCase(repository, mapperCharacter).invoke()
}

@KtorExperimentalAPI
suspend fun getRaces(): List<Race>? {
    val api = CharacterApi(defaultCIOHttpClient)
    val repository = CharacterRepository(api)
    val mapper = CharacterResponseToRaceMapper()
    val useCase = GetAllRacesUseCase(repository, mapper)
    return useCase.invoke()
}

@KtorExperimentalAPI
suspend fun getGenders(): List<Gender>? {
    val api = CharacterApi(defaultCIOHttpClient)
    val repository = CharacterRepository(api)
    val mapper = CharacterResponseToGenderMapper()
    val useCase = GetAllGendersUseCase(repository, mapper)
    return useCase.invoke()
}

@KtorExperimentalAPI
suspend fun getRealms(): List<Realm>? {
    val api = CharacterApi(defaultCIOHttpClient)
    val repository = CharacterRepository(api)
    val mapper = CharacterResponseToRealmMapper()
    val useCase = GetAllRealmsUseCase(repository, mapper)
    return useCase.invoke()
}
