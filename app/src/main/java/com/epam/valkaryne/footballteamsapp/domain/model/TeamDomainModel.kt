package com.epam.valkaryne.footballteamsapp.domain.model

/**
 * Data class that represents team's info for domain layer
 */
data class TeamDomainModel(
    val id: Long,
    val name: String,
    val crestUrl: String?
)