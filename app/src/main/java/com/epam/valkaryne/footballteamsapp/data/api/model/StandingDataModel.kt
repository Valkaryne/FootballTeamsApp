package com.epam.valkaryne.footballteamsapp.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that represents information about a standing
 */
data class StandingDataModel(
    @field:SerializedName("stage") val stage: String?,
    @field:SerializedName("type") val type: String?,
    @field:SerializedName("group") val group: String?,
    @field:SerializedName("table") val table: List<TeamStatsDataModel>?,
)