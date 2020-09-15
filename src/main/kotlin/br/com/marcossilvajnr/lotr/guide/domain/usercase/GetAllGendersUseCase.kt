package br.com.marcossilvajnr.lotr.guide.domain.usercase

import br.com.marcossilvajnr.lotr.guide.data.repository.CharacterRepository
import br.com.marcossilvajnr.lotr.guide.domain.mapper.CharacterResponseToGenderMapper
import br.com.marcossilvajnr.lotr.guide.domain.model.Gender

open class GetAllGendersUseCase constructor(
    private val repository: CharacterRepository,
    private val mapper: CharacterResponseToGenderMapper
): BaseUseCase<List<Gender>?> {
    override suspend fun invoke(): List<Gender>? {
        return repository.getAllCharacters().docs?.map(mapper::transform)
    }
}