package com.matheuslima.valorantcompose.domain.usecase

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.domain.model.MapDomain
import com.matheuslima.valorantcompose.domain.repository.WeaponsRepository
import com.matheuslima.valorantcompose.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeaponsUseCase @Inject constructor(private val repository: WeaponsRepository) {
    suspend operator fun invoke(language: String?): Flow<BaseResponse<List<WeaponDomain>>> {
        return repository.getWeapons(language)
    }
}

class GetMapsUseCase @Inject constructor(private val repository: MapsRepository) {
    suspend operator fun invoke(language: String?): Flow<BaseResponse<List<MapDomain>>> {
        return repository.getMaps(language)
    }
}
