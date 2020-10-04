package com.epam.valkaryne.footballteamsapp.data.repository.mappers

import com.epam.valkaryne.footballteamsapp.common.BaseMapper
import com.epam.valkaryne.footballteamsapp.data.api.model.TeamDataModel
import com.epam.valkaryne.footballteamsapp.domain.model.TeamDomailModel

/**
 * Mapper that transforms football team's data
 */
object TeamDomainModelMapper : BaseMapper<TeamDataModel, TeamDomailModel> {

    override fun map(modelType: TeamDataModel?): TeamDomailModel {
        return TeamDomailModel(
            id = modelType?.id ?: -1,
            name = modelType?.name ?: "",
            crestUrl = modelType?.crestUrl
        )
    }
}