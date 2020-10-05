package com.epam.valkaryne.footballteamsapp.domain.model

/**
 * Data class that represents team player's info for domain layer
 */
data class PlayerDomainModel(
    val id: Long,
    val name: String,
    val position: String,
    val dateOfBirth: String,
    val countryOfBirth: String,
    val nationality: String
)