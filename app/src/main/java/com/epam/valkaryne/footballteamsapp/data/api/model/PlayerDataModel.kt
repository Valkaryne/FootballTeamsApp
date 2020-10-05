package com.epam.valkaryne.footballteamsapp.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that represents info about a football team player
 */
data class PlayerDataModel(
    @field:SerializedName("id") val id: Long?,
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("position") val position: String?,
    @field:SerializedName("dateOfBirth") val dateOfBirth: String?,
    @field:SerializedName("countryOfBirth") val countryOfBirth: String?,
    @field:SerializedName("nationality") val nationality: String?,
    @field:SerializedName("role") val role: String?
)