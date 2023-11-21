package com.matheuslima.valorantcompose.data.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.data.response.entities.Agents
import kotlinx.coroutines.flow.Flow

interface AgentsRepository {
    suspend fun getAgents(language: String?): Flow<BaseResponse<Agents>>
}