package com.matheuslima.valorantcompose.data.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.utilities.exceptions.AgentsDataNotReceivedException
import com.matheuslima.utilities.exceptions.EmptyDataException
import com.matheuslima.valorantcompose.data.datasource.interfaces.AgentsDataSource
import com.matheuslima.valorantcompose.domain.mapper.toDomain
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import com.matheuslima.valorantcompose.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AgentsRepositoryImpl @Inject constructor(private val agentsDataSource: AgentsDataSource) :
    AgentsRepository {

    override suspend fun getAgents(language: String?): Flow<BaseResponse<List<AgentDomain>>> = flow {
        emit(BaseResponse.Loading())
        val response = agentsDataSource.getAgents(language)
        if (response.isSuccessful && response.body() != null) {
            val agents = response.body()?.data?.map { it.toDomain() } ?: emptyList()
            emit(BaseResponse.Success(agents))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(AgentsDataNotReceivedException(e))) }

    override suspend fun getAgentByUuid(agentUuid: String, language: String?): Flow<BaseResponse<AgentDomain>> = flow {
        emit(BaseResponse.Loading())
        val response = agentsDataSource.getAgentByUuid(agentUuid, language)
        if (response.isSuccessful && response.body() != null) {
            val agent = response.body()?.data?.toDomain()
            if (agent != null) {
                emit(BaseResponse.Success(agent))
            } else {
                emit(BaseResponse.Error(EmptyDataException()))
            }
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(AgentsDataNotReceivedException(e))) }
}
