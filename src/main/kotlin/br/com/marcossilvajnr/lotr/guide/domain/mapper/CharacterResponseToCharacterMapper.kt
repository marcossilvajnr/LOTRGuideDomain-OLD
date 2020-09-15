package br.com.marcossilvajnr.lotr.guide.domain.mapper

import br.com.marcossilvajnr.lotr.guide.data.base.BaseLayerDataTransformer
import br.com.marcossilvajnr.lotr.guide.data.models.CharacterResponseModel
import br.com.marcossilvajnr.lotr.guide.domain.model.Character

class CharacterResponseToCharacterMapper constructor(
    private val genderMapper: CharacterResponseToGenderMapper,
    private val realmMapper: CharacterResponseToRealmMapper,
    private val raceMapper: CharacterResponseToRaceMapper
): BaseLayerDataTransformer<CharacterResponseModel, Character>() {
    override fun transform(from: CharacterResponseModel): Character {
        return Character(
            id = from._id,
            race = raceMapper.transform(from),
            gender = genderMapper.transform(from),
            realm = realmMapper.transform(from),
            name = from.name,
            birth = from.birth,
            death = from.death,
            hair = from.hair,
            height = from.height,
            spouse = from.spouse,
            wikiUrl = from.wikiUrl
        )
    }
}