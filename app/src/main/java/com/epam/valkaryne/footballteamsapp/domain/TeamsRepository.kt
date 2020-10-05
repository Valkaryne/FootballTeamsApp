package com.epam.valkaryne.footballteamsapp.domain

import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.domain.model.TeamDomainModel
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel

/**
 * Repository that works with teams from FootballData API
 */
interface TeamsRepository {

    /**
     * Get a list with statistic with all football teams from the certain league
     *
     * @param id the id of a league
     * @return a wrapped result of the request
     */
    suspend fun getAllTeamsStats(id: Long): Result<TeamsStatsDomainModel>

    /**
     * Get a detailed information about the certain team
     *
     * @param id the id of a team
     * @return a wrapped result of the request
     */
    suspend fun getTeamDetails(id: Long): Result<TeamDomainModel>
}