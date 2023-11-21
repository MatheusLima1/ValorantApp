package com.matheuslima.valorantcompose.data.api

import com.matheuslima.utilities.UtilConstants.US
import com.matheuslima.valorantcompose.data.response.entities.Agents
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("agents")
    suspend fun getAgents(
        @Query("language") language: String? = US
    ): Response<Agents>
}