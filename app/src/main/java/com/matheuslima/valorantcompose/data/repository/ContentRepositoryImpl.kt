package com.matheuslima.valorantcompose.data.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.utilities.exceptions.BaseException
import com.matheuslima.utilities.exceptions.EmptyDataException
import com.matheuslima.valorantcompose.data.api.ApiService
import com.matheuslima.valorantcompose.domain.mapper.*
import com.matheuslima.valorantcompose.domain.model.*
import com.matheuslima.valorantcompose.domain.repository.ContentRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ContentRepository {

    override fun getTitles(language: String?): Flow<BaseResponse<List<TitleDomain>>> = flow {
        emit(BaseResponse.Loading<List<TitleDomain>>())
        val response = apiService.getTitles(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<List<TitleDomain>>(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error<List<TitleDomain>>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<List<TitleDomain>>(object : BaseException(e, e.message) {})) }

    override fun getTitleByUuid(uuid: String, language: String?): Flow<BaseResponse<TitleDomain>> = flow {
        emit(BaseResponse.Loading<TitleDomain>())
        val response = apiService.getTitleByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<TitleDomain>(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error<TitleDomain>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<TitleDomain>(object : BaseException(e, e.message) {})) }

    override fun getPlayerCards(language: String?): Flow<BaseResponse<List<PlayerCardDomain>>> = flow {
        emit(BaseResponse.Loading<List<PlayerCardDomain>>())
        val response = apiService.getPlayerCards(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<List<PlayerCardDomain>>(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error<List<PlayerCardDomain>>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<List<PlayerCardDomain>>(object : BaseException(e, e.message) {})) }

    override fun getPlayerCardByUuid(uuid: String, language: String?): Flow<BaseResponse<PlayerCardDomain>> = flow {
        emit(BaseResponse.Loading<PlayerCardDomain>())
        val response = apiService.getPlayerCardByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<PlayerCardDomain>(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error<PlayerCardDomain>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<PlayerCardDomain>(object : BaseException(e, e.message) {})) }

    override fun getCurrencies(language: String?): Flow<BaseResponse<List<CurrencyDomain>>> = flow {
        emit(BaseResponse.Loading<List<CurrencyDomain>>())
        val response = apiService.getCurrencies(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<List<CurrencyDomain>>(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error<List<CurrencyDomain>>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<List<CurrencyDomain>>(object : BaseException(e, e.message) {})) }

    override fun getCurrencyByUuid(uuid: String, language: String?): Flow<BaseResponse<CurrencyDomain>> = flow {
        emit(BaseResponse.Loading<CurrencyDomain>())
        val response = apiService.getCurrencyByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<CurrencyDomain>(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error<CurrencyDomain>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<CurrencyDomain>(object : BaseException(e, e.message) {})) }

    override fun getGameModes(language: String?): Flow<BaseResponse<List<GameModeDomain>>> = flow {
        emit(BaseResponse.Loading<List<GameModeDomain>>())
        val response = apiService.getGameModes(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<List<GameModeDomain>>(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error<List<GameModeDomain>>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<List<GameModeDomain>>(object : BaseException(e, e.message) {})) }

    override fun getGameModeByUuid(uuid: String, language: String?): Flow<BaseResponse<GameModeDomain>> = flow {
        emit(BaseResponse.Loading<GameModeDomain>())
        val response = apiService.getGameModeByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<GameModeDomain>(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error<GameModeDomain>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<GameModeDomain>(object : BaseException(e, e.message) {})) }

    override fun getSeasons(language: String?): Flow<BaseResponse<List<SeasonDomain>>> = flow {
        emit(BaseResponse.Loading<List<SeasonDomain>>())
        val response = apiService.getSeasons(language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<List<SeasonDomain>>(response.body()!!.data.map { it.toDomain() }))
        } else {
            emit(BaseResponse.Error<List<SeasonDomain>>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<List<SeasonDomain>>(object : BaseException(e, e.message) {})) }

    override fun getSeasonByUuid(uuid: String, language: String?): Flow<BaseResponse<SeasonDomain>> = flow {
        emit(BaseResponse.Loading<SeasonDomain>())
        val response = apiService.getSeasonByUuid(uuid, language)
        if (response.isSuccessful && response.body() != null) {
            emit(BaseResponse.Success<SeasonDomain>(response.body()!!.data.toDomain()))
        } else {
            emit(BaseResponse.Error<SeasonDomain>(EmptyDataException()))
        }
    }.catch { e -> emit(BaseResponse.Error<SeasonDomain>(object : BaseException(e, e.message) {})) }
}
