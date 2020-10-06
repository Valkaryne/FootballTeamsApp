package com.epam.valkaryne.footballteamsapp.domain.usecase

import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.domain.TeamsRepository
import com.epam.valkaryne.footballteamsapp.domain.model.TeamDomainModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.IOException

class GetTeamDetailsUseCaseTest {

    private val mockTeamsRepository: TeamsRepository = mockk()
    private val getTeamDetailsUseCase = GetTeamDetailsUseCase(mockTeamsRepository)

    @Test
    fun `when execute usecase should call repository`() {
        runBlocking {
            coEvery { mockTeamsRepository.getTeamDetails(any()) } returns Result.success(TEAM)

            getTeamDetailsUseCase.executeUseCase(ID)

            coVerify { mockTeamsRepository.getTeamDetails(ID) }
        }
    }

    @Test
    fun `when execute use case should return team details`() {
        runBlocking {
            coEvery { mockTeamsRepository.getTeamDetails(any()) } returns Result.success(TEAM)

            val result = getTeamDetailsUseCase.executeUseCase(ID).data

            assertEquals(TEAM, result)
        }
    }

    @Test
    fun `when repository returns certain error should proceed the same`() {
        runBlocking {
            coEvery { mockTeamsRepository.getTeamDetails(any()) } returns Result.error(IOException())

            val result = getTeamDetailsUseCase.executeUseCase(ID).error

            assertTrue(result is IOException)
        }
    }

    private companion object {
        const val ID = 18L
        val TEAM = TeamDomainModel(
            id = ID,
            name = "Borussia Mönchengladbach",
            shortName = "M'gladbach",
            tla = "BMG",
            crestUrl = "https://media.org/Borussia.svg",
            address = "Hennes-Weisweiler-Allee 1",
            phone = "+49",
            website = "http://www.borussia.de",
            email = "info@borussia.de",
            founded = 1900,
            clubColors = "Black / White / Green",
            venue = "Stadion im Borussia-Park",
            squad = listOf()
        )
    }
}