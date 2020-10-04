package com.epam.valkaryne.footballteamsapp.vm.model

/**
 * Data class that represents information about team's statistics
 */
data class TeamStatsViewStateModel(
    val id: Long,
    val name: String,
    val crestUrl: String?,
    val position: Int,
    val playedGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val points: Int,
    val goalDifference: Int
)