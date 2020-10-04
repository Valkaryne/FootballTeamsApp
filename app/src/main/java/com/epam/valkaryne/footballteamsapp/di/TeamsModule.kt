package com.epam.valkaryne.footballteamsapp.di

import com.epam.valkaryne.footballteamsapp.domain.usecase.GetTeamsStatsUseCase
import com.epam.valkaryne.footballteamsapp.vm.TeamsStatsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val teamsStatsModule = module {
    factory { GetTeamsStatsUseCase(repository = get()) }

    viewModel {
        TeamsStatsViewModel(getTeamsStatsUseCase = get())
    }
}