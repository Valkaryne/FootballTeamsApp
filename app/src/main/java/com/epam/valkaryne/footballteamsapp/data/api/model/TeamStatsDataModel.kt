package com.epam.valkaryne.footballteamsapp.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that represents statistics of teams in the certain standing's table
 */
data class TeamStatsDataModel(
    @field:SerializedName("position") val position: Int?,
    @field:SerializedName("team") val team: TeamDataModel?,
    @field:SerializedName("playedGames") val playedGames: Int?,
    @field:SerializedName("won") val won: Int?,
    @field:SerializedName("draw") val draw: Int?,
    @field:SerializedName("lost") val lost: Int?,
    @field:SerializedName("points") val points: Int?,
    @field:SerializedName("goalsFor") val goalsFor: Int?,
    @field:SerializedName("goalsAgainst") val goalsAgainst: Int?,
    @field:SerializedName("goalDifference") val goalDifference: Int?
)