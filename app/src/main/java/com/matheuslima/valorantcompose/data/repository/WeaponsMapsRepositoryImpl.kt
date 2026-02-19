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
        emit(BaseResponse.Loading())
        val response = apiService.getWeapons(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override suspend fun getWeaponByUuid(weaponUuid: String, language: String?): Flow<BaseResponse<WeaponDomain>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getWeaponByUuid(weaponUuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }
}

class MapsRepositoryImpl @Inject constructor(private val apiService: ApiService) : MapsRepository {
    override suspend fun getMaps(language: String?): Flow<BaseResponse<List<MapDomain>>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getMaps(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override suspend fun getMapByUuid(mapUuid: String, language: String?): Flow<BaseResponse<MapDomain>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getMapByUuid(mapUuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }
}
