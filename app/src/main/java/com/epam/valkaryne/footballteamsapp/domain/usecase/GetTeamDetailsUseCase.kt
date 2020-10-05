package com.epam.valkaryne.footballteamsapp.domain.usecase

import com.epam.valkaryne.footballteamsapp.domain.TeamsRepository

/**
 * Domain logic to get football team's details from API
 */
class GetTeamDetailsUseCase(private val repository: TeamsRepository) {

     /**
     * Executes domain logic
     *
     * @return wrapped result with team's details
     */
    suspend fun executeUseCase(id: Long) = repository.getTeamDetails(id)
}