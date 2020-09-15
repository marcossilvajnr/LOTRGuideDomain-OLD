package br.com.marcossilvajnr.lotr.guide.domain.usercase

import br.com.marcossilvajnr.lotr.guide.data.repository.CharacterRepository
import br.com.marcossilvajnr.lotr.guide.domain.mapper.CharacterResponseToRealmMapper
import br.com.marcossilvajnr.lotr.guide.domain.model.Realm

open class GetAllRealmsUseCase constructor(
    private val repository: CharacterRepository,
    private val mapper: CharacterResponseToRealmMapper
): BaseUseCase<List<Realm>?> {
    override suspend fun invoke(): List<Realm>? {
        return repository.getAllCharacters().docs?.map(mapper::transform)
    }
}