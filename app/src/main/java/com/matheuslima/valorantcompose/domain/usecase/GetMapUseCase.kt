package com.matheuslima.valorantcompose.domain.usecase

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.MapDomain
import com.matheuslima.valorantcompose.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMapUseCase @Inject constructor(
    private val repository: MapsRepository
) {
    suspend operator fun invoke(mapUuid: String, language: String? = null): Flow<BaseResponse<MapDomain>> {
        return repository.getMapByUuid(mapUuid, language)
    }
}
