package com.matheuslima.valorantcompose.domain.usecase

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.*
import com.matheuslima.valorantcompose.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTitleDetailUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(uuid: String, language: String? = null): Flow<BaseResponse<TitleDomain>> = repository.getTitleByUuid(uuid, language)
}

class GetPlayerCardDetailUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(uuid: String, language: String? = null): Flow<BaseResponse<PlayerCardDomain>> = repository.getPlayerCardByUuid(uuid, language)
}

class GetCurrencyDetailUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(uuid: String, language: String? = null): Flow<BaseResponse<CurrencyDomain>> = repository.getCurrencyByUuid(uuid, language)
}

class GetGameModeDetailUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(uuid: String, language: String? = null): Flow<BaseResponse<GameModeDomain>> = repository.getGameModeByUuid(uuid, language)
}

class GetSeasonDetailUseCase @Inject constructor(private val repository: ContentRepository) {
    operator fun invoke(uuid: String, language: String? = null): Flow<BaseResponse<SeasonDomain>> = repository.getSeasonByUuid(uuid, language)
}
