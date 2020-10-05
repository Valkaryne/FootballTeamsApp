package com.epam.valkaryne.footballteamsapp.vm.model

/**
 * Data class that represents short info about team's player
 */
data class PlayerInfo(
    val id: Long,
    val name: String,
    val position: String
)