package com.matheuslima.valorantcompose.domain.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.domain.model.MapDomain
import kotlinx.coroutines.flow.Flow

interface WeaponsRepository {
    suspend fun getWeapons(language: String?): Flow<BaseResponse<List<WeaponDomain>>>
    suspend fun getWeaponByUuid(weaponUuid: String, language: String?): Flow<BaseResponse<WeaponDomain>>
}

interface MapsRepository {
    suspend fun getMaps(language: String?): Flow<BaseResponse<List<MapDomain>>>
    suspend fun getMapByUuid(mapUuid: String, language: String?): Flow<BaseResponse<MapDomain>>
}
