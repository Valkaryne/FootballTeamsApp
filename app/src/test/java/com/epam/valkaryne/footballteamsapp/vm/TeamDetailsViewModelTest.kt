package com.epam.valkaryne.footballteamsapp.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.epam.valkaryne.footballteamsapp.MainCoroutineRule
import com.epam.valkaryne.footballteamsapp.common.datatype.Result
import com.epam.valkaryne.footballteamsapp.domain.model.TeamDomainModel
import com.epam.valkaryne.footballteamsapp.domain.usecase.GetTeamDetailsUseCase
import com.epam.valkaryne.footballteamsapp.vm.model.TeamDetailsViewStateModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class TeamDetailsViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val mainCoroutineRule = MainCoroutineRule()

    private val mockGetTeamDetailsUseCase: GetTeamDetailsUseCase = mockk()
    private val viewModel = TeamDetailsViewModel(mockGetTeamDetailsUseCase)

    @Test
    fun `when getting team details invoked should call usecase`() {
        mainCoroutineRule.runBlockingTest {
            coEvery { mockGetTeamDetailsUseCase.executeUseCase(any()) } returns Result.success(
                DOMAIN_TEAM
            )

            viewModel.getTeamDetails(ID)

            coVerify { mockGetTeamDetailsUseCase.executeUseCase(ID) }
        }
    }

    @Test
    fun `when getting team details invoked should set Loading state`() {
        mainCoroutineRule.runBlockingTest {
            coEvery { mockGetTeamDetailsUseCase.executeUseCase(any()) } returns Result.success(
                DOMAIN_TEAM
            )

            mainCoroutineRule.pauseDispatcher()
            viewModel.getTeamDetails(ID)

            assertEquals(ViewState.Loading, viewModel.teamDetailsViewState.value)
            mainCoroutineRule.resumeDispatcher()
        }
    }

    @Test
    fun `when team details got should set Success state`() {
        mainCoroutineRule.runBlockingTest {
            coEvery { mockGetTeamDetailsUseCase.executeUseCase(any()) } returns Result.success(
                DOMAIN_TEAM
            )

            viewModel.getTeamDetails(ID)

            assertEquals(ViewState.Success(VIEW_MODEL_TEAM), viewModel.teamDetailsViewState.value)
        }
    }

    @Test
    fun `when team details got with error should set Error state`() {
        mainCoroutineRule.runBlockingTest {
            val error = Exception("random error")
            coEvery { mockGetTeamDetailsUseCase.executeUseCase(any()) } returns Result.error(error)

            viewModel.getTeamDetails(ID)

            assertEquals(ViewState.Error(error), viewModel.teamDetailsViewState.value)
        }
    }

    private companion object {
        const val ID = 18L
        val DOMAIN_TEAM = TeamDomainModel(
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

        val VIEW_MODEL_TEAM = TeamDetailsViewStateModel(
            id = ID,
            name = "Borussia Mönchengladbach",
            crestUrl = "https://media.org/Borussia.svg",
            address = "Hennes-Weisweiler-Allee 1",
            phone = "+49",
            website = "http://www.borussia.de",
            founded = 1900,
            clubColors = "Black / White / Green",
            venue = "Stadion im Borussia-Park",
            squad = listOf()
        )
    }
}