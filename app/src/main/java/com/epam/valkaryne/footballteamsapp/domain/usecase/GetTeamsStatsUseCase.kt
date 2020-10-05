package com.epam.valkaryne.footballteamsapp.domain.usecase

import com.epam.valkaryne.footballteamsapp.domain.TeamsRepository
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel
import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.common.datatype.ResultType

/**
 * Domain logic to get football teams' statistics from API
 */
class GetTeamsStatsUseCase(private val repository: TeamsRepository) {

    /**
     * Executes domain logic
     *
     * @return wrapped result with list of teams' statistics
     */
    suspend fun executeUseCase(): Result<TeamsStatsDomainModel> {
        var teamsStats: Result<TeamsStatsDomainModel>

        repository.getAllTeamsStats().let {
            teamsStats = if (it.resultType == ResultType.SUCCESS) {
                Result.success(
                    getSortedByGoalsDifferenceStats(it.data)
                )
            } else {
                it
            }
        }

        return teamsStats
    }

    private fun getSortedByGoalsDifferenceStats(stats: TeamsStatsDomainModel?): TeamsStatsDomainModel {
        return TeamsStatsDomainModel(stats?.teamsStats?.sortedByDescending { it.goalDifference } ?: listOf())
    }
}