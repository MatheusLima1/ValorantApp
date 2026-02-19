package com.matheuslima.valorantcompose.domain.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import kotlinx.coroutines.flow.Flow

interface AgentsRepository {
    suspend fun getAgents(language: String?): Flow<BaseResponse<List<AgentDomain>>>
    suspend fun getAgentByUuid(agentUuid: String, language: String?): Flow<BaseResponse<AgentDomain>>
}
