package com.epam.valkaryne.footballteamsapp.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that represents info about the certain football team
 */
data class TeamDataModel(
    @field:SerializedName("id") val id: Long?,
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("shortName") val shortName: String?,
    @field:SerializedName("tla") val tla: String?,
    @field:SerializedName("crestUrl") val crestUrl: String?,
    @field:SerializedName("address") val address: String?,
    @field:SerializedName("phone") val phone: String?,
    @field:SerializedName("website") val website: String?,
    @field:SerializedName("email") val email: String?,
    @field:SerializedName("founded") val founded: Int?,
    @field:SerializedName("clubColors") val clubColors: String?,
    @field:SerializedName("venue") val venue: String?,
    @field:SerializedName("squad") val squad: List<PlayerDataModel>?
)