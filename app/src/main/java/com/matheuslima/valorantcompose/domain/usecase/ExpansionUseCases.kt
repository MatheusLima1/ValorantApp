package com.matheuslima.valorantcompose.domain.usecase

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.*
import com.matheuslima.valorantcompose.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTitlesUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(language: String? = null): Flow<BaseResponse<List<TitleDomain>>> = repository.getTitles(language)
}

class GetPlayerCardsUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(language: String? = null): Flow<BaseResponse<List<PlayerCardDomain>>> = repository.getPlayerCards(language)
}

class GetCurrenciesUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(language: String? = null): Flow<BaseResponse<List<CurrencyDomain>>> = repository.getCurrencies(language)
}

class GetGameModesUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(language: String? = null): Flow<BaseResponse<List<GameModeDomain>>> = repository.getGameModes(language)
}

class GetSeasonsUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(language: String? = null): Flow<BaseResponse<List<SeasonDomain>>> = repository.getSeasons(language)
}
