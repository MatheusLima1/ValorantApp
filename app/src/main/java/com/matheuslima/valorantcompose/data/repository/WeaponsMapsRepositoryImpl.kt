package com.matheuslima.valorantcompose.data.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.utilities.exceptions.BaseException
import com.matheuslima.utilities.exceptions.EmptyDataException
import com.matheuslima.valorantcompose.data.api.ApiService
import com.matheuslima.valorantcompose.domain.mapper.toDomain
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.domain.model.MapDomain
import com.matheuslima.valorantcompose.domain.repository.WeaponsRepository
import com.matheuslima.valorantcompose.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeaponsRepositoryImpl @Inject constructor(private val apiService: ApiService) : WeaponsRepository {
    override suspend fun getWeapons(language: String?): Flow<BaseResponse<List<WeaponDomain>>> = flow {
        emit(BaseResponse.Loading<List<WeaponDomain>>())
        val response = apiService.getWeapons(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<List<WeaponDomain>>(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error<List<WeaponDomain>>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<List<WeaponDomain>>(object : BaseException(e, e.message) {})) }

    override suspend fun getWeaponByUuid(weaponUuid: String, language: String?): Flow<BaseResponse<WeaponDomain>> = flow {
        emit(BaseResponse.Loading<WeaponDomain>())
        val response = apiService.getWeaponByUuid(weaponUuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<WeaponDomain>(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error<WeaponDomain>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<WeaponDomain>(object : BaseException(e, e.message) {})) }
}

class MapsRepositoryImpl @Inject constructor(private val apiService: ApiService) : MapsRepository {
    override suspend fun getMaps(language: String?): Flow<BaseResponse<List<MapDomain>>> = flow {
        emit(BaseResponse.Loading<List<MapDomain>>())
        val response = apiService.getMaps(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<List<MapDomain>>(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error<List<MapDomain>>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<List<MapDomain>>(object : BaseException(e, e.message) {})) }

    override suspend fun getMapByUuid(mapUuid: String, language: String?): Flow<BaseResponse<MapDomain>> = flow {
        emit(BaseResponse.Loading<MapDomain>())
        val response = apiService.getMapByUuid(mapUuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<MapDomain>(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error<MapDomain>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<MapDomain>(object : BaseException(e, e.message) {})) }
}
