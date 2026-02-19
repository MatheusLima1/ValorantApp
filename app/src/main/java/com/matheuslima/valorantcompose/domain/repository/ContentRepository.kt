package com.matheuslima.valorantcompose.domain.repository

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.*
import kotlinx.coroutines.flow.Flow

interface ContentRepository {
    fun getTitles(language: String? = null): Flow<BaseResponse<List<TitleDomain>>>
    fun getTitleByUuid(uuid: String, language: String? = null): Flow<BaseResponse<TitleDomain>>
    
    fun getPlayerCards(language: String? = null): Flow<BaseResponse<List<PlayerCardDomain>>>
    fun getPlayerCardByUuid(uuid: String, language: String? = null): Flow<BaseResponse<PlayerCardDomain>>
    
    fun getCurrencies(language: String? = null): Flow<BaseResponse<List<CurrencyDomain>>>
    fun getCurrencyByUuid(uuid: String, language: String? = null): Flow<BaseResponse<CurrencyDomain>>
    
    fun getGameModes(language: String? = null): Flow<BaseResponse<List<GameModeDomain>>>
    fun getGameModeByUuid(uuid: String, language: String? = null): Flow<BaseResponse<GameModeDomain>>
    
    fun getSeasons(language: String? = null): Flow<BaseResponse<List<SeasonDomain>>>
    fun getSeasonByUuid(uuid: String, language: String? = null): Flow<BaseResponse<SeasonDomain>>
}
