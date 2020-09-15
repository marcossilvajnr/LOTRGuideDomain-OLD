package br.com.marcossilvajnr.lotr.guide.domain.mapper

import br.com.marcossilvajnr.lotr.guide.data.base.BaseLayerDataTransformer
import br.com.marcossilvajnr.lotr.guide.data.models.CharacterResponseModel
import br.com.marcossilvajnr.lotr.guide.domain.model.Race

class CharacterResponseToRaceMapper: BaseLayerDataTransformer<CharacterResponseModel, Race>() {
    override fun transform(from: CharacterResponseModel): Race {
        return Race(
            name = from.race
        )
    }
}