package com.matheuslima.valorantcompose.data.datasource.remote

import com.matheuslima.valorantcompose.data.api.ApiService
import com.matheuslima.valorantcompose.data.datasource.interfaces.AgentsDataSource
import com.matheuslima.valorantcompose.data.response.entities.Agents
import com.matheuslima.valorantcompose.data.response.entities.SingleAgentResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteAgentsDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    AgentsDataSource {
    override suspend fun getAgents(language: String?): Response<Agents> {
        return apiService.getAgents(language)
    }

    override suspend fun getAgentByUuid(agentUuid: String, language: String?): Response<SingleAgentResponse> {
        return apiService.getAgentByUuid(agentUuid, language)
    }
}