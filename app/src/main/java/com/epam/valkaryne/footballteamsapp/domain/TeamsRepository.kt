package com.epam.valkaryne.footballteamsapp.domain

import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel

/**
 * Repository that works with teams from FootballData API
 */
interface TeamsRepository {

    /**
     * Get a list with statistic with all football teams from the certain league
     *
     * @return a wrapped result of the request
     */
    suspend fun getAllTeamsStats(): Result<TeamsStatsDomainModel>
}