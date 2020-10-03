package com.epam.valkaryne.footballteamsapp.data.repository.mappers

import com.epam.valkaryne.footballteamsapp.common.BaseMapper
import com.epam.valkaryne.footballteamsapp.data.api.model.TeamDataModel
import com.epam.valkaryne.footballteamsapp.domain.model.TeamDomailModel

/**
 * Mapper that transforms football team's data
 */
object TeamDomainModelMapper : BaseMapper<TeamDataModel, TeamDomailModel> {

    override fun map(model: TeamDataModel?): TeamDomailModel {
        return TeamDomailModel(
            id = model?.id ?: -1,
            name = model?.name ?: "",
            crestUrl = model?.crestUrl
        )
    }
}