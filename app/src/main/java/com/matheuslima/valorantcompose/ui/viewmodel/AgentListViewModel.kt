package com.matheuslima.valorantcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import com.matheuslima.valorantcompose.domain.usecase.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentListViewModel @Inject constructor(private val getAgentsUseCase: GetAgentsUseCase) :
    ViewModel() {

    private val _agents: MutableStateFlow<BaseResponse<List<AgentDomain>>> =
        MutableStateFlow(BaseResponse.Loading())

    //delegation
//    var state by mutableStateOf<BaseResponse<Agents>>(BaseResponse.Loading())
//        private set

    val agents: StateFlow<BaseResponse<List<AgentDomain>>> = _agents

    fun getAgents(language: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            getAgentsUseCase(language).collectLatest { agentsResponse ->
                _agents.value = agentsResponse
            }
        }
    }

    init {
        getAgents(null)
    }
}