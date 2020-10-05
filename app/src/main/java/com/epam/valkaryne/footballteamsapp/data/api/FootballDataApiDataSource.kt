package com.epam.valkaryne.footballteamsapp.data.api

import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.data.api.model.StandingDataModel
import com.epam.valkaryne.footballteamsapp.data.api.model.TeamDataModel
import com.epam.valkaryne.footballteamsapp.data.api.retrofit.FootballDataApiService

/**
 * Data source to send requests to API and to get response from
 */
class FootballDataApiDataSource(private val service: FootballDataApiService) {

    /**
     * Gets from API standings for a particular competition.
     *
     * @return wrapped result of the request
     */
    suspend fun getStandings(): Result<List<StandingDataModel>> {
        return try {
            val response = service.getStandings()
            Result.success(response.standings)
        } catch (ex: Exception) {
            Result.error(ex)
        }
    }

    /**
     * Gets from API detailed information for a one particular team.
     *
     * @param id the id of a team
     * @return wrapped result of the request
     */
    suspend fun getTeam(id: Long): Result<TeamDataModel> {
        return try {
            val response = service.getTeam(id)
            Result.success(response)
        } catch (ex: Exception) {
            Result.error(ex)
        }
    }
}