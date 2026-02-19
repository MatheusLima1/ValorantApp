package com.matheuslima.valorantcompose.ui.viewmodel

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import com.matheuslima.valorantcompose.domain.usecase.GetAgentsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AgentListViewModelTest {

    private val getAgentsUseCase: GetAgentsUseCase = mockk()
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getAgents should update agents StateFlow with success`() = runTest {
        val agents = listOf(mockk<AgentDomain>())
        coEvery { getAgentsUseCase(any()) } returns flowOf(BaseResponse.Success(agents))

        val viewModel = AgentListViewModel(getAgentsUseCase)
        
        assertEquals(agents, (viewModel.agents.value as BaseResponse.Success).data)
    }

    @Test
    fun `getAgents should update agents StateFlow with error`() = runTest {
        val error = Exception("Error")
        coEvery { getAgentsUseCase(any()) } returns flowOf(BaseResponse.Error(error))

        val viewModel = AgentListViewModel(getAgentsUseCase)
        
        assert(viewModel.agents.value is BaseResponse.Error)
        assertEquals(error, (viewModel.agents.value as BaseResponse.Error).error.cause)
    }
}
