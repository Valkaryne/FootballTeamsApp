package com.epam.valkaryne.footballteamsapp.vm.mappers

import com.epam.valkaryne.footballteamsapp.common.BaseMapper
import com.epam.valkaryne.footballteamsapp.domain.model.TeamDomainModel
import com.epam.valkaryne.footballteamsapp.vm.ViewState
import com.epam.valkaryne.footballteamsapp.vm.model.PlayerInfo
import com.epam.valkaryne.footballteamsapp.vm.model.TeamDetailsViewStateModel

/**
 * Mapper that transforms team's details data to view state
 */
object TeamDetailsViewStateMapper :
    BaseMapper<TeamDomainModel, ViewState<TeamDetailsViewStateModel, Exception>> {

    override fun invoke(modelType: TeamDomainModel?): ViewState<TeamDetailsViewStateModel, Exception> {
        return if (modelType == null) {
            ViewState.Error(Exception("No details"))
        } else {
            ViewState.Success(
                TeamDetailsViewStateModel(
                    id = modelType.id,
                    name = modelType.name,
                    crestUrl = modelType.crestUrl,
                    address = modelType.address,
                    phone = modelType.phone,
                    website = modelType.website,
                    founded = modelType.founded,
                    clubColors = modelType.clubColors,
                    venue = modelType.venue,
                    squad = modelType.squad.map { PlayerInfo(it.id, it.name, it.position) }
                )
            )
        }
    }
}