package com.matheuslima.valorantcompose.domain.usecase

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import com.matheuslima.valorantcompose.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(
    private val repository: AgentsRepository
) {
    suspend operator fun invoke(language: String?): Flow<BaseResponse<List<AgentDomain>>> {
        return repository.getAgents(language)
    }
}
