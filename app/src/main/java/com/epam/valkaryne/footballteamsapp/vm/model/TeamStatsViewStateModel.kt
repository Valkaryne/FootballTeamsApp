package com.epam.valkaryne.footballteamsapp.vm.model

data class TeamStatsViewStateModel(
    val id: Long,
    val name: String,
    val crestUrl: String?,
    val position: Int,
    val playedGames: Int,
    val won: Int,
    val lost: Int,
    val draw: Int,
    val goalDifference: Int
)