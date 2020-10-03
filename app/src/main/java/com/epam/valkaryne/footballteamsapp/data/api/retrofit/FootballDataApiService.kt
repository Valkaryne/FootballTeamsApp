package com.epam.valkaryne.footballteamsapp.data.api.retrofit

import com.epam.valkaryne.footballteamsapp.data.api.model.StandingsResponse
import retrofit2.http.GET

/**
 * Retrofit service that works with API
 */
interface FootballDataApiService {

    @GET("v2/competitions/2021/standings?standingType=TOTAL")
    suspend fun getStandings(): StandingsResponse
}