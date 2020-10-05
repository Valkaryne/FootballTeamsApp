package com.epam.valkaryne.footballteamsapp.data.repository.mappers

import com.epam.valkaryne.footballteamsapp.common.BaseMapper
import com.epam.valkaryne.footballteamsapp.data.api.model.PlayerDataModel
import com.epam.valkaryne.footballteamsapp.domain.model.PlayerDomainModel

/**
 * Mapper that transforms team player's data
 */
object PlayerDomainModelMapper : BaseMapper<PlayerDataModel, PlayerDomainModel> {

    override fun invoke(modelType: PlayerDataModel?): PlayerDomainModel {
        return PlayerDomainModel(
            id = modelType?.id ?: -1,
            name = modelType?.name ?: "",
            position = modelType?.position ?: modelType?.role ?: "",
            dateOfBirth = modelType?.dateOfBirth ?: "",
            countryOfBirth = modelType?.countryOfBirth ?: "",
            nationality = modelType?.nationality ?: ""
        )
    }
}