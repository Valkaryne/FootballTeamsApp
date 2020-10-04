package com.epam.valkaryne.footballteamsapp.vm.mappers

import com.epam.valkaryne.footballteamsapp.common.BaseMapper
import com.epam.valkaryne.footballteamsapp.domain.model.TeamStatsDomainModel
import com.epam.valkaryne.footballteamsapp.vm.ViewState
import com.epam.valkaryne.footballteamsapp.vm.model.TeamStatsViewStateModel

/**
 * Mapper that transforms teams' statistic data to view state
 */
object TeamsStatsViewStateMapper :
    BaseMapper<List<TeamStatsDomainModel>?, ViewState<List<TeamStatsViewStateModel>, Exception>> {

    override fun map(modelType: List<TeamStatsDomainModel>?): ViewState<List<TeamStatsViewStateModel>, Exception> {
        return ViewState.Success(
            modelType?.map {
                TeamStatsViewStateModel(
                    id = it.team.id,
                    name = it.team.name,
                    crestUrl = it.team.crestUrl,
                    position = it.position,
                    playedGames = it.playedGames,
                    won = it.won,
                    draw = it.draw,
                    lost = it.lost,
                    points = it.points,
                    goalDifference = it.goalDifference
                )
            } ?: listOf()
        )
    }
}