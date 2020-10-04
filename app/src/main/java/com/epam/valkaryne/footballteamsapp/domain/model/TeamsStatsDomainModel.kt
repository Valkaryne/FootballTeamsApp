package com.epam.valkaryne.footballteamsapp.domain.model

/**
 * Data class that wraps list of teams' statistics for domain layer
 */
data class TeamsStatsDomainModel(
    val teamsStats: List<TeamStatsDomainModel>
)