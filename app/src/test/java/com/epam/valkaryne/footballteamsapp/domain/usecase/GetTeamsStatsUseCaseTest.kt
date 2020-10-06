package com.epam.valkaryne.footballteamsapp.domain.usecase

import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.domain.TeamsRepository
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel
import com.epam.valkaryne.footballteamsapp.domain.utils.DomainTeamsStatsGenerator
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.IOException

class GetTeamsStatsUseCaseTest {

    private val mockTeamsRepository: TeamsRepository = mockk()
    private val getTeamsStatsUseCase = GetTeamsStatsUseCase(mockTeamsRepository)

    @Test
    fun `when execute usecase should call repository`() {
        runBlocking {
            coEvery { mockTeamsRepository.getAllTeamsStats(any()) } returns Result.success(
                TeamsStatsDomainModel(listOf())
            )

            getTeamsStatsUseCase.executeUseCase(ID)

            coVerify { mockTeamsRepository.getAllTeamsStats(ID) }
        }
    }

    @Test
    fun `when execute use case should return list sorted by goal difference`() {
        runBlocking {
            val result = Result.success(DomainTeamsStatsGenerator.getUnsortedTeamsStats())

            coEvery { mockTeamsRepository.getAllTeamsStats(any()) } returns result

            val expectedUseCaseResult =
                Result.success(DomainTeamsStatsGenerator.getSortedTeamsStats()).data
            val realUseCaseResult = getTeamsStatsUseCase.executeUseCase(ID).data

            realUseCaseResult?.teamsStats?.forEachIndexed { index, real ->
                val currentExpected = expectedUseCaseResult?.teamsStats?.get(index)?.goalDifference
                val currentReal = real.goalDifference

                assertEquals(currentExpected, currentReal)
            }
        }
    }

    @Test
    fun `when repository returns certain error should proceed the same`() {
        runBlocking {
            coEvery { mockTeamsRepository.getAllTeamsStats(any()) } returns Result.error(IOException())

            val result = getTeamsStatsUseCase.executeUseCase(ID).error

            assertTrue(result is IOException)
        }
    }

    private companion object {
        const val ID = 1001L
    }
}