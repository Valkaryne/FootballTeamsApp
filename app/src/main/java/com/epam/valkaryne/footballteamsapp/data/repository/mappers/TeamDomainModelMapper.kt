package com.epam.valkaryne.footballteamsapp.data.repository.mappers

import com.epam.valkaryne.footballteamsapp.common.BaseMapper
import com.epam.valkaryne.footballteamsapp.data.api.model.TeamDataModel
import com.epam.valkaryne.footballteamsapp.domain.model.TeamDomainModel

/**
 * Mapper that transforms football team's data
 */
object TeamDomainModelMapper : BaseMapper<TeamDataModel, TeamDomainModel> {

    override fun map(modelType: TeamDataModel?): TeamDomainModel {
        return TeamDomainModel(
            id = modelType?.id ?: -1,
            name = modelType?.name ?: "",
            crestUrl = modelType?.crestUrl
        )
    }
}