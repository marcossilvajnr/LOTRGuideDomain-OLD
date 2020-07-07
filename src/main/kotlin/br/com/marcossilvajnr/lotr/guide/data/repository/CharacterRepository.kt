package br.com.marcossilvajnr.lotr.guide.data.repository

import br.com.marcossilvajnr.lotr.guide.data.datasource.CharacterDataSource

class CharacterRepository(private val dataSource: CharacterDataSource) {
    suspend fun getAllCharacters() = dataSource.getAllCharacters()
}