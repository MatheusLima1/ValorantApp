package com.matheuslima.valorantcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.data.repository.AgentsRepository
import com.matheuslima.valorantcompose.data.response.entities.Agents
import com.matheuslima.valorantcompose.ui.helper.DefaultDispatchers
import com.matheuslima.valorantcompose.ui.helper.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentListViewModel @Inject constructor(private val agentsRepository: AgentsRepository) :
    ViewModel() {

    private val _agents: MutableStateFlow<BaseResponse<Agents>> =
        MutableStateFlow(BaseResponse.Loading())

    //delegation
//    var state by mutableStateOf<BaseResponse<Agents>>(BaseResponse.Loading())
//        private set

    val agents: StateFlow<BaseResponse<Agents>> = _agents.asStateFlow()

    fun getAgents(language: String?) {
        viewModelScope.launch(DefaultDispatchers().io) {
            agentsRepository.getAgents(language).collectLatest { agentsResponse ->
                _agents.value = agentsResponse
            }
        }
    }

    init {
        getAgents(null)
    }
}