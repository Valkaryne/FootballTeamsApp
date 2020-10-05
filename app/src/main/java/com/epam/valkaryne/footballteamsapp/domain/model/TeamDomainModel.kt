package com.epam.valkaryne.footballteamsapp.domain.model

/**
 * Data class that represents team's info for domain layer
 */
data class TeamDomainModel(
    val id: Long,
    val name: String,
    val shortName: String,
    val tla: String,
    val crestUrl: String?,
    val address: String,
    val phone: String,
    val website: String,
    val email: String,
    val founded: Int,
    val clubColors: String,
    val venue: String,
    val squad: List<PlayerDomainModel>
)