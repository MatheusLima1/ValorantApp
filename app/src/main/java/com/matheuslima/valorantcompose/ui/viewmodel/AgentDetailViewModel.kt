package com.matheuslima.valorantcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import com.matheuslima.valorantcompose.domain.usecase.GetAgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val getAgentUseCase: GetAgentUseCase
) : ViewModel() {

    private val _agent: MutableStateFlow<BaseResponse<AgentDomain>> = MutableStateFlow(BaseResponse.Loading())
    val agent: StateFlow<BaseResponse<AgentDomain>> = _agent

    fun getAgent(uuid: String) {
        viewModelScope.launch {
            getAgentUseCase(uuid).collectLatest { response ->
                _agent.value = response
            }
        }
    }
}
