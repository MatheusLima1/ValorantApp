package com.matheuslima.valorantcompose.data.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.utilities.exceptions.BaseException
import com.matheuslima.utilities.exceptions.EmptyDataException
import com.matheuslima.valorantcompose.data.api.ApiService
import com.matheuslima.valorantcompose.domain.mapper.toDomain
import com.matheuslima.valorantcompose.domain.model.*
import com.matheuslima.valorantcompose.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ContentRepository {

    override fun getTitles(language: String?): Flow<BaseResponse<List<TitleDomain>>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getTitles(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getTitleByUuid(uuid: String, language: String?): Flow<BaseResponse<TitleDomain>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getTitleByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getPlayerCards(language: String?): Flow<BaseResponse<List<PlayerCardDomain>>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getPlayerCards(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getPlayerCardByUuid(uuid: String, language: String?): Flow<BaseResponse<PlayerCardDomain>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getPlayerCardByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getCurrencies(language: String?): Flow<BaseResponse<List<CurrencyDomain>>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getCurrencies(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getCurrencyByUuid(uuid: String, language: String?): Flow<BaseResponse<CurrencyDomain>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getCurrencyByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getGameModes(language: String?): Flow<BaseResponse<List<GameModeDomain>>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getGameModes(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getGameModeByUuid(uuid: String, language: String?): Flow<BaseResponse<GameModeDomain>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getGameModeByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getSeasons(language: String?): Flow<BaseResponse<List<SeasonDomain>>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getSeasons(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }

    override fun getSeasonByUuid(uuid: String, language: String?): Flow<BaseResponse<SeasonDomain>> = flow {
        emit(BaseResponse.Loading())
        val response = apiService.getSeasonByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error(object : BaseException(e, e.message) {})) }
}
