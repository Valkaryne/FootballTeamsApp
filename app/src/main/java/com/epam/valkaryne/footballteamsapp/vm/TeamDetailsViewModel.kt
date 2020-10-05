package com.epam.valkaryne.footballteamsapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epam.valkaryne.footballteamsapp.common.datatype.ResultType
import com.epam.valkaryne.footballteamsapp.domain.usecase.GetTeamDetailsUseCase
import com.epam.valkaryne.footballteamsapp.vm.mappers.TeamDetailsViewStateMapper
import com.epam.valkaryne.footballteamsapp.vm.model.TeamDetailsViewStateModel
import kotlinx.coroutines.launch

/**
 * ViewModel that works with getting team's detailed information from football-data API
 */
class TeamDetailsViewModel(private val getTeamDetailsUseCase: GetTeamDetailsUseCase) : ViewModel() {

    private val _teamDetailsViewState =
        MutableLiveData<ViewState<TeamDetailsViewStateModel, Exception>>()
    val teamDetailsViewState: LiveData<ViewState<TeamDetailsViewStateModel, Exception>> =
        _teamDetailsViewState

    /**
     * Gets details of the selected football team
     *
     * @param id the id of the selected football team
     */
    fun getTeamDetails(id: Long) {
        _teamDetailsViewState.value = ViewState.Loading
        viewModelScope.launch {
            getTeamDetailsUseCase.executeUseCase(id).let { result ->
                if (result.resultType == ResultType.SUCCESS) {
                    _teamDetailsViewState.value = TeamDetailsViewStateMapper(result.data)
                } else {
                    _teamDetailsViewState.value = ViewState.Error(result.error!!)
                }
            }
        }
    }
}