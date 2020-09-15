package br.com.marcossilvajnr.lotr.guide.domain.mapper

import br.com.marcossilvajnr.lotr.guide.data.base.BaseLayerDataTransformer
import br.com.marcossilvajnr.lotr.guide.data.models.CharacterResponseModel
import br.com.marcossilvajnr.lotr.guide.domain.model.Gender

class CharacterResponseToGenderMapper: BaseLayerDataTransformer<CharacterResponseModel, Gender>() {
    override fun transform(from: CharacterResponseModel): Gender {
        return Gender(
            name = from.gender
        )
    }
}