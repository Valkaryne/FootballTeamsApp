package com.epam.valkaryne.footballteamsapp.data.api.retrofit

import com.epam.valkaryne.footballteamsapp.data.api.model.StandingsResponse
import com.epam.valkaryne.footballteamsapp.data.api.model.TeamDataModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit service that works with API
 */
interface FootballDataApiService {

    @GET("v2/competitions/2021/standings?standingType=TOTAL")
    suspend fun getStandings(): StandingsResponse

    @GET("/v2/teams/{id}")
    suspend fun getTeam(@Path("id") id: Long): TeamDataModel
}