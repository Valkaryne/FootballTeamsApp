package com.epam.valkaryne.footballteamsapp.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.epam.valkaryne.footballteamsapp.MainCoroutineRule
import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.domain.model.TeamsStatsDomainModel
import com.epam.valkaryne.footballteamsapp.domain.usecase.GetTeamsStatsUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class TeamStatsViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val mainCoroutineRule = MainCoroutineRule()

    private val mockGetTeamsStatsUseCase: GetTeamsStatsUseCase = mockk()
    private val viewModel = TeamsStatsViewModel(mockGetTeamsStatsUseCase)

    @Test
    fun `when getting stats invoked should call usecase`() {
        mainCoroutineRule.runBlockingTest {
            coEvery { mockGetTeamsStatsUseCase.executeUseCase(any()) } returns Result.success(
                TeamsStatsDomainModel(listOf())
            )

            viewModel.getAllTeamsStats(ID)

            coVerify { mockGetTeamsStatsUseCase.executeUseCase(ID) }
        }
    }

    @Test
    fun `when getting stats invoked should set Loading state`() {
        mainCoroutineRule.runBlockingTest {
            coEvery { mockGetTeamsStatsUseCase.executeUseCase(any()) } returns Result.success(
                TeamsStatsDomainModel(listOf())
            )

            mainCoroutineRule.pauseDispatcher()
            viewModel.getAllTeamsStats(ID)

            assertEquals(ViewState.Loading, viewModel.teamsStatsViewState.value)
            mainCoroutineRule.resumeDispatcher()
        }
    }

    @Test
    fun `when stats got should set Success state`() {
        mainCoroutineRule.runBlockingTest {
            coEvery { mockGetTeamsStatsUseCase.executeUseCase(any()) } returns Result.success(
                TeamsStatsDomainModel(listOf())
            )

            viewModel.getAllTeamsStats(ID)

            assertTrue(viewModel.teamsStatsViewState.value is ViewState.Success)
        }
    }

    @Test
    fun `when stats got with error should set Error state`() {
        mainCoroutineRule.runBlockingTest {
            val error = Exception("random error")
            coEvery { mockGetTeamsStatsUseCase.executeUseCase(any()) } returns Result.error(error)

            viewModel.getAllTeamsStats(ID)

            assertEquals(ViewState.Error(error), viewModel.teamsStatsViewState.value)
        }
    }

    private companion object {
        const val ID = 1001L
    }
}