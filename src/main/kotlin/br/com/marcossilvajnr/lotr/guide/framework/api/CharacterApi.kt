package br.com.marcossilvajnr.lotr.guide.framework.api

import br.com.marcossilvajnr.lotr.guide.data.datasource.CharacterDataSource
import br.com.marcossilvajnr.lotr.guide.data.models.CharactersBaseResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class CharacterApi(
    private val client: HttpClient
): CharacterDataSource {

    override suspend fun getAllCharacters() = client.get<CharactersBaseResponseModel> {
        url { encodedPath = "/v1/character" }
    }
}