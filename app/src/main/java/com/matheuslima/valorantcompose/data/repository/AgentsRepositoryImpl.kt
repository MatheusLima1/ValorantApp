package com.matheuslima.valorantcompose.data.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.utilities.exceptions.AgentsDataNotReceivedException
import com.matheuslima.utilities.exceptions.BaseException
import com.matheuslima.utilities.exceptions.EmptyDataException
import com.matheuslima.valorantcompose.data.datasource.interfaces.AgentsDataSource
import com.matheuslima.valorantcompose.data.response.entities.Agents
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AgentsRepositoryImpl @Inject constructor(private val agentsDataSource: AgentsDataSource) :
    AgentsRepository {

    override suspend fun getAgents(language: String?): Flow<BaseResponse<Agents>> = flow {
        emit(BaseResponse.Loading())
        val response = agentsDataSource.getAgents(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(AgentsDataNotReceivedException(e))) }
}
