package com.matheuslima.valorantcompose.data.datasource.interfaces

import com.matheuslima.valorantcompose.data.response.entities.Agents
import retrofit2.Response

interface AgentsDataSource {
    suspend fun getAgents(language: String?): Response<Agents>
}