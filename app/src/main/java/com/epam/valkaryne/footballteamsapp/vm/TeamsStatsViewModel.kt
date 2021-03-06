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

/**
 * ViewModel that works with getting teams' statistics from football-data API
 */
class TeamsStatsViewModel(private val getTeamsStatsUseCase: GetTeamsStatsUseCase) : ViewModel() {

    private val _teamsStatsViewState =
        MutableLiveData<ViewState<List<TeamStatsViewStateModel>, Exception>>()
    val teamsStatsViewState: LiveData<ViewState<List<TeamStatsViewStateModel>, Exception>> =
        _teamsStatsViewState

    /**
     * Gets teams' statistics for the selected league
     *
     * @param id the id of the selected league
     */
    fun getAllTeamsStats(id: Long) {
        _teamsStatsViewState.value = ViewState.Loading
        viewModelScope.launch {
            getTeamsStatsUseCase.executeUseCase(id).let { result ->
                if (result.resultType == ResultType.SUCCESS) {
                    _teamsStatsViewState.value =
                        TeamsStatsViewStateMapper(result.data?.teamsStats)
                } else {
                    _teamsStatsViewState.value = ViewState.Error(result.error!!)
                }
            }
        }
    }
}