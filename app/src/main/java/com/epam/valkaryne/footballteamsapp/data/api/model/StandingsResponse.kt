package com.epam.valkaryne.footballteamsapp.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that represents the response from GetStandings request
 */
data class StandingsResponse(
    @field:SerializedName("standings") val standings: List<StandingDataModel>
)