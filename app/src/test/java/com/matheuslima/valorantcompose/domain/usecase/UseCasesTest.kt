package com.matheuslima.valorantcompose.domain.usecase

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.repository.AgentsRepository
import com.matheuslima.valorantcompose.domain.repository.WeaponsRepository
import com.matheuslima.valorantcompose.domain.repository.MapsRepository
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.domain.model.MapDomain
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class UseCasesTest {

    private val agentsRepository: AgentsRepository = mockk()
    private val weaponsRepository: WeaponsRepository = mockk()
    private val mapsRepository: MapsRepository = mockk()

    private val getAgentsUseCase = GetAgentsUseCase(agentsRepository)
    private val getWeaponsUseCase = GetWeaponsUseCase(weaponsRepository)
    private val getMapsUseCase = GetMapsUseCase(mapsRepository)

    @Test
    fun `getAgentsUseCase should return agents from repository`() = runBlocking {
        val agents = listOf(mockk<AgentDomain>())
        coEvery { agentsRepository.getAgents(any()) } returns flowOf(BaseResponse.Success(agents))

        getAgentsUseCase(null).collect { response ->
            assert(response is BaseResponse.Success)
            assertEquals(agents, (response as BaseResponse.Success).data)
        }
    }

    @Test
    fun `getWeaponsUseCase should return weapons from repository`() = runBlocking {
        val weapons = listOf(mockk<WeaponDomain>())
        coEvery { weaponsRepository.getWeapons(any()) } returns flowOf(BaseResponse.Success(weapons))

        getWeaponsUseCase(null).collect { response ->
            assert(response is BaseResponse.Success)
            assertEquals(weapons, (response as BaseResponse.Success).data)
        }
    }

    @Test
    fun `getMapsUseCase should return maps from repository`() = runBlocking {
        val maps = listOf(mockk<MapDomain>())
        coEvery { mapsRepository.getMaps(any()) } returns flowOf(BaseResponse.Success(maps))

        getMapsUseCase(null).collect { response ->
            assert(response is BaseResponse.Success)
            assertEquals(maps, (response as BaseResponse.Success).data)
        }
    }
}
