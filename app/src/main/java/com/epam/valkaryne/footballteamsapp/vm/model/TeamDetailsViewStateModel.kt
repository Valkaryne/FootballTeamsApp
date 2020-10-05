package com.epam.valkaryne.footballteamsapp.vm.model

/**
 * Data class that represents detailed information about a team
 */
data class TeamDetailsViewStateModel(
    val id: Long,
    val name: String,
    val crestUrl: String?,
    val address: String,
    val phone: String,
    val website: String,
    val founded: Int,
    val clubColors: String,
    val venue: String,
    val squad: List<PlayerInfo>
)