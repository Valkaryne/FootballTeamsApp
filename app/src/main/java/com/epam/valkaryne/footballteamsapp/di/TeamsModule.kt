package com.epam.valkaryne.footballteamsapp.di

import com.epam.valkaryne.footballteamsapp.domain.usecase.GetTeamDetailsUseCase
import com.epam.valkaryne.footballteamsapp.domain.usecase.GetTeamsStatsUseCase
import com.epam.valkaryne.footballteamsapp.view.adapter.TeamStatsAdapter
import com.epam.valkaryne.footballteamsapp.vm.TeamDetailsViewModel
import com.epam.valkaryne.footballteamsapp.vm.TeamsStatsViewModel
import com.epam.valkaryne.footballteamsapp.vm.model.TeamStatsViewStateModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val teamsStatsModule = module {
    factory { GetTeamsStatsUseCase(repository = get()) }

    viewModel {
        TeamsStatsViewModel(getTeamsStatsUseCase = get())
    }

    factory { (teamDetailsListener: (TeamStatsViewStateModel) -> Unit) ->
        TeamStatsAdapter(listener = teamDetailsListener)
    }
}

val teamDetailsModule = module {
    factory { GetTeamDetailsUseCase(repository = get()) }

    viewModel {
        TeamDetailsViewModel(getTeamDetailsUseCase = get())
    }
}