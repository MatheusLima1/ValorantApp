package com.matheuslima.valorantcompose.mockData

import com.matheuslima.valorantcompose.data.response.entities.Agent
import com.matheuslima.valorantcompose.data.response.entities.Agents
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

object AgentMockedDataObject {
    private val errorResponse =
        "{\n" +
                "  \"type\": \"error\",\n" +
                "  \"message\": \"What you were looking for isn't here.\"\n" +
                "}"
    private val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
    private var agentsEmptyList = arrayListOf<Agent>()
    private var agentsList = arrayListOf(
        Agent(displayName = "Gekko"),
        Agent(displayName = "Fade"),
        Agent(displayName = "Breach")
    )

    private var emptyAgents = Agents(agentsEmptyList, 200)
    val agents = Agents(agentsList, 200)
    val responseSuccess = Response.success(agents)
    val responseSuccessEmpty = Response.success(emptyAgents)
    val mockErrorResponse = Response.error<Agents>(400, errorResponseBody)

}