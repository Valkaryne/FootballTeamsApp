package com.epam.valkaryne.footballteamsapp.data.repository.mappers

import com.epam.valkaryne.footballteamsapp.common.BaseMapper
import com.epam.valkaryne.footballteamsapp.data.api.model.TeamStatsDataModel
import com.epam.valkaryne.footballteamsapp.domain.model.TeamStatsDomainModel
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel

/**
 * Mapper that transforms teams' statistic data
 */
object TeamsStatsDomainModelMapper :
    BaseMapper<List<TeamStatsDataModel>, TeamsStatsDomainModel> {

    override fun map(modelList: List<TeamStatsDataModel>?): TeamsStatsDomainModel {
        return TeamsStatsDomainModel(
            modelList?.map {
                TeamStatsDomainModel(
                    position = it.position ?: -1,
                    team = TeamDomainModelMapper.map(it.team),
                    playedGames = it.playedGames ?: 0,
                    won = it.won ?: 0,
                    draw = it.draw ?: 0,
                    lost = it.lost ?: 0,
                    points = it.points ?: 0,
                    goalsFor = it.goalsFor ?: 0,
                    goalsAgainst = it.goalsAgainst ?: 0,
                    goalDifference = it.goalDifference ?: 0
                )
            } ?: listOf()
        )
    }
}