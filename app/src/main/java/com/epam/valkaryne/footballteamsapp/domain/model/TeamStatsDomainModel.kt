package com.epam.valkaryne.footballteamsapp.domain.model

data class TeamStatsDomainModel(
    val position: Int,
    val team: TeamDomailModel,
    val playedGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val points: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int
)