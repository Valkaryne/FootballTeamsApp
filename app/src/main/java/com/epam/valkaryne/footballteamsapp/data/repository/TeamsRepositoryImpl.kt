package com.epam.valkaryne.footballteamsapp.data.repository

import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.common.datatype.ResultType
import com.epam.valkaryne.footballteamsapp.data.api.FootballDataApiDataSource
import com.epam.valkaryne.footballteamsapp.data.repository.mappers.TeamsStatsDomainModelMapper
import com.epam.valkaryne.footballteamsapp.domain.TeamsRepository
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel

class TeamsRepositoryImpl(private val dataSource: FootballDataApiDataSource) : TeamsRepository {

    override suspend fun getAllTeamsStats(): Result<TeamsStatsDomainModel> {
        val standingsResult = dataSource.getStandings()

        return if (standingsResult.resultType == ResultType.SUCCESS) {
            Result.success(TeamsStatsDomainModelMapper.map(standingsResult.data?.firstOrNull { it.table != null }?.table))
        } else {
            Result.error(standingsResult.error)
        }
    }
}