package com.epam.valkaryne.footballteamsapp.data.api.retrofit

import retrofit2.http.GET

interface FootballDataApiService {

    @GET("v2/competitions/2021/standings?standingType=TOTAL")
    suspend fun getStandings()
}