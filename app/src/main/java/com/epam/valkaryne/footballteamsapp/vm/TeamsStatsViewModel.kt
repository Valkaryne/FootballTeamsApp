package com.epam.valkaryne.footballteamsapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epam.valkaryne.footballteamsapp.common.datatype.ResultType
import com.epam.valkaryne.footballteamsapp.domain.usecase.GetTeamsStatsUseCase
import com.epam.valkaryne.footballteamsapp.vm.mappers.TeamsStatsViewStateMapper
import com.epam.valkaryne.footballteamsapp.vm.model.TeamStatsViewStateModel
import kotlinx.coroutines.launch

class TeamsStatsViewModel(private val getTeamsStatsUseCase: GetTeamsStatsUseCase) : ViewModel() {

    private val _teamsStatsViewState =
        MutableLiveData<ViewState<List<TeamStatsViewStateModel>, Exception>>()
    private val teamsStatsViewState: LiveData<ViewState<List<TeamStatsViewStateModel>, Exception>> =
        _teamsStatsViewState

    fun getAllTeamsStats() {
        _teamsStatsViewState.value = ViewState.Loading
        viewModelScope.launch {
            getTeamsStatsUseCase.executeUseCase().let { result ->
                if (result.resultType == ResultType.SUCCESS) {
                    _teamsStatsViewState.value =
                        TeamsStatsViewStateMapper.map(result.data?.teamsStats)
                } else {
                    _teamsStatsViewState.value = ViewState.Error(result.error!!)
                }
            }
        }
    }
}