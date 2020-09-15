package br.com.marcossilvajnr.lotr.guide.domain.usercase

import br.com.marcossilvajnr.lotr.guide.data.repository.CharacterRepository
import br.com.marcossilvajnr.lotr.guide.domain.mapper.CharacterResponseToCharacterMapper
import br.com.marcossilvajnr.lotr.guide.domain.model.Character

open class GetAllCharactersUseCase constructor(
    private val repository: CharacterRepository,
    private val mapper: CharacterResponseToCharacterMapper
): BaseUseCase<List<Character>?> {
    override suspend fun invoke() = repository.getAllCharacters().docs?.map(mapper::transform)
}