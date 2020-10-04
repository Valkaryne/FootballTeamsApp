package com.epam.valkaryne.footballteamsapp.domain.model

/**
 * Data class that represents team's statistics for domain layer
 */
data class TeamStatsDomainModel(
    val position: Int,
    val team: TeamDomainModel,
    val playedGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val points: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int
)