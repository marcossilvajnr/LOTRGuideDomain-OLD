package br.com.marcossilvajnr.lotr.guide.domain.mapper

import br.com.marcossilvajnr.lotr.guide.data.base.BaseLayerDataTransformer
import br.com.marcossilvajnr.lotr.guide.data.models.CharacterResponseModel
import br.com.marcossilvajnr.lotr.guide.domain.model.Realm

class CharacterResponseToRealmMapper: BaseLayerDataTransformer<CharacterResponseModel, Realm>() {
    override fun transform(from: CharacterResponseModel): Realm {
        return Realm(
            name = from.realm
        )
    }
}