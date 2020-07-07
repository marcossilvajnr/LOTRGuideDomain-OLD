package br.com.marcossilvajnr.lotr.guide.data.datasource

import br.com.marcossilvajnr.lotr.guide.data.models.CharactersBaseResponseModel

interface CharacterDataSource {
    suspend fun getAllCharacters(): CharactersBaseResponseModel
}