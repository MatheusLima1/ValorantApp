package com.matheuslima.valorantcompose.data.repository

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.data.datasource.interfaces.AgentsDataSource
import com.matheuslima.valorantcompose.data.response.entities.Agents
import com.matheuslima.valorantcompose.mockData.AgentMockedDataObject.agents
import com.matheuslima.valorantcompose.mockData.AgentMockedDataObject.mockErrorResponse
import com.matheuslima.valorantcompose.mockData.AgentMockedDataObject.responseSuccess
import com.matheuslima.valorantcompose.mockData.AgentMockedDataObject.responseSuccessEmpty
import com.matheuslima.valorantcompose.testHelper.TestDispatchers
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AgentsRepositoryImplTest {
    private var agentsDataSource: AgentsDataSource = mockk<AgentsDataSource>()
    private lateinit var agentRepository: AgentsRepositoryImpl
    private lateinit var testDispatchers: TestDispatchers
    private val baseResponse = mockk<BaseResponse.Loading<Agents>>()
    @Before
    fun setUp() {
        testDispatchers = TestDispatchers()
        agentRepository = AgentsRepositoryImpl(agentsDataSource, testDispatchers)
    }
    @Test
    fun givenAnErrorResponseWhenStartRequestThenVerifyErrorBody() = runTest {
        coEvery { agentsDataSource.getAgents(any()) } returns mockErrorResponse
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
        assert(data.body()!!.data[1].displayName == "Fade")
        assert(data.body()!!.data[2].displayName == "Breach")
    }

    @Test
    fun givenAnSuccessEmptyResponseWhenRequestDataThenVerifySuccessBody() = runTest {
        coEvery { agentsDataSource.getAgents(any()) } returns responseSuccessEmpty
        val data = runBlocking { agentsDataSource.getAgents(null) }
        assert(data.body()!!.data.isEmpty())
    }

//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Test
//    fun `foo`() = runBlocking {
//        val loading = BaseResponse.Loading<Agents>()
//        coEvery { agentsDataSource.getAgents(any()) } returns responseSuccess
//        coEvery { baseResponse } returns loading
//        val agentsNames = BaseResponse.Success(agents.data)
//
//        agentRepository.getAgents("").test {
//            testDispatchers.testDispatcher.scheduler.apply { advanceTimeBy(1000L); runCurrent() }
//            val emission = awaitItem()
//            assertThat(emission).isEqualTo(loading)
//            cancelAndConsumeRemainingEvents()
//        }
//    }
}