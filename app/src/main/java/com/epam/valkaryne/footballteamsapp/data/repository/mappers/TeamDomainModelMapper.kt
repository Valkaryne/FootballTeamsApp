package com.epam.valkaryne.footballteamsapp.data.repository.mappers

import com.epam.valkaryne.footballteamsapp.common.BaseMapper
import com.epam.valkaryne.footballteamsapp.data.api.model.TeamDataModel
import com.epam.valkaryne.footballteamsapp.domain.model.TeamDomainModel

/**
 * Mapper that transforms football team's data
 */
object TeamDomainModelMapper : BaseMapper<TeamDataModel, TeamDomainModel> {

    override fun invoke(modelType: TeamDataModel?): TeamDomainModel {
        return TeamDomainModel(
            id = modelType?.id ?: -1,
            name = modelType?.name ?: "",
            shortName = modelType?.shortName ?: "",
            tla = modelType?.tla ?: "",
            crestUrl = modelType?.crestUrl,
            address = modelType?.address ?: "",
            phone = modelType?.phone ?: "",
            website = modelType?.website ?: "",
            email = modelType?.email ?: "",
            founded = modelType?.founded ?: -1,
            clubColors = modelType?.clubColors ?: "",
            venue = modelType?.venue ?: "",
            squad = modelType?.squad?.map { PlayerDomainModelMapper(it) } ?: listOf()
        )
    }
}