package br.com.marcossilvajnr.lotr.guide.domain.usercase

import br.com.marcossilvajnr.lotr.guide.data.repository.CharacterRepository
import br.com.marcossilvajnr.lotr.guide.domain.mapper.CharacterResponseToRaceMapper
import br.com.marcossilvajnr.lotr.guide.domain.model.Race

open class GetAllRacesUseCase constructor(
    private val repository: CharacterRepository,
    private val mapper: CharacterResponseToRaceMapper
): BaseUseCase<List<Race>?> {
    override suspend fun invoke(): List<Race>? {
        val formattedRaces = repository.getAllCharacters().docs
            ?.map(mapper::transform)
            ?.distinctBy { it.name }
            ?.toMutableList()

        formattedRaces?.forEachIndexed { index, race ->
            if (race.name.isNullOrEmpty()) {
                formattedRaces[index] = race.copy(name = Race.DEFAULT_NAME)
            }
        }

        return formattedRaces
    }
}