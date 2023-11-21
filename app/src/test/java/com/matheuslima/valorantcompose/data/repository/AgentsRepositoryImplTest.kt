package com.matheuslima.valorantcompose.data.repository

import com.matheuslima.valorantcompose.data.datasource.interfaces.AgentsDataSource
import com.matheuslima.valorantcompose.data.response.entities.Agent
import com.matheuslima.valorantcompose.data.response.entities.Agents
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.Response

class AgentsRepositoryImplTest {
    private var agentsDataSource: AgentsDataSource = mockk<AgentsDataSource>()
    private var agentsEmptyList = arrayListOf<Agent>()
    private var agentsList = arrayListOf(
        Agent(displayName = "Gekko"),
        Agent(displayName = "Fade"),
        Agent(displayName = "Breach")
    )
    private var agents = Agents(agentsList, 200)
    private var emptyAgents = Agents(agentsEmptyList, 200)
    private val responseSuccess = Response.success(agents)
    private val responseSuccessEmpty = Response.success(emptyAgents)
    val errorResponse =
        "{\n" +
                "  \"type\": \"error\",\n" +
                "  \"message\": \"What you were looking for isn't here.\"\n" +
                "}"
    val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
    val mockResponse = Response.error<Agents>(400, errorResponseBody)

    @Test
    fun givenAnErrorResponseWhenStartRequestThenVerifyErrorBody() = runTest {
        coEvery { agentsDataSource.getAgents(any()) } returns mockResponse
        val data = runBlocking { agentsDataSource.getAgents(null) }
        assert(data.code() == 400)
        assert(data.message() == "Response.error()")
    }

    @Test
    fun givenAnSuccessNotEmptyResponseWhenRequestDataThenVerifySuccessBody() = runTest {
        coEvery { agentsDataSource.getAgents(any()) } returns responseSuccess
        val data = runBlocking { agentsDataSource.getAgents(null) }
        assert(data.body()!!.data.isNotEmpty())
        assert(data.body()!!.data.size == 3)
        assert(data.body()!!.data[0].displayName == "Gekko")
    }

    @Test
    fun givenAnSuccessEmptyResponseWhenRequestDataThenVerifySuccessBody() = runTest {
        coEvery { agentsDataSource.getAgents(any()) } returns responseSuccessEmpty
        val data = runBlocking { agentsDataSource.getAgents(null) }
        assert(data.body()!!.data.isEmpty())
    }
}