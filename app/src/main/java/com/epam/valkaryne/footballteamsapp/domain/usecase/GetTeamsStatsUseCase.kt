package com.epam.valkaryne.footballteamsapp.domain.usecase

import com.epam.valkaryne.footballteamsapp.domain.TeamsRepository
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel
import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.common.datatype.ResultType

class GetTeamsStatsUseCase(private val repository: TeamsRepository) {

    suspend fun executeUseCase(): Result<TeamsStatsDomainModel> {
        var teamsStats: Result<TeamsStatsDomainModel>

        repository.getAllTeamsStats().let {
            teamsStats = if (it.resultType == ResultType.SUCCESS) {
                Result.success(
                    getSortedByGoalsDifferenceStats(it.data)
                )
            } else {
                Result.error(it.error)
            }
        }
        
        return teamsStats
    }

    private fun getSortedByGoalsDifferenceStats(stats: TeamsStatsDomainModel?): TeamsStatsDomainModel {
        return TeamsStatsDomainModel(stats?.teamsStats?.sortedBy { it.goalDifference } ?: listOf())
    }
}