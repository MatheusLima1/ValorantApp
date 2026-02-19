package com.matheuslima.valorantcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.*
import com.matheuslima.valorantcompose.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpansionViewModel @Inject constructor(
    private val getTitlesUseCase: GetTitlesUseCase,
    private val getPlayerCardsUseCase: GetPlayerCardsUseCase,
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val getGameModesUseCase: GetGameModesUseCase,
    private val getSeasonsUseCase: GetSeasonsUseCase
) : ViewModel() {

    private val _titles: MutableStateFlow<BaseResponse<List<TitleDomain>>> = MutableStateFlow(BaseResponse.Loading())
    val titles: StateFlow<BaseResponse<List<TitleDomain>>> = _titles

    private val _playerCards: MutableStateFlow<BaseResponse<List<PlayerCardDomain>>> = MutableStateFlow(BaseResponse.Loading())
    val playerCards: StateFlow<BaseResponse<List<PlayerCardDomain>>> = _playerCards

    private val _currencies: MutableStateFlow<BaseResponse<List<CurrencyDomain>>> = MutableStateFlow(BaseResponse.Loading())
    val currencies: StateFlow<BaseResponse<List<CurrencyDomain>>> = _currencies

    private val _gameModes: MutableStateFlow<BaseResponse<List<GameModeDomain>>> = MutableStateFlow(BaseResponse.Loading())
    val gameModes: StateFlow<BaseResponse<List<GameModeDomain>>> = _gameModes

    private val _seasons: MutableStateFlow<BaseResponse<List<SeasonDomain>>> = MutableStateFlow(BaseResponse.Loading())
    val seasons: StateFlow<BaseResponse<List<SeasonDomain>>> = _seasons

    fun getTitles() {
        viewModelScope.launch {
            getTitlesUseCase().collectLatest { _titles.value = it }
        }
    }

    fun getPlayerCards() {
        viewModelScope.launch {
            getPlayerCardsUseCase().collectLatest { _playerCards.value = it }
        }
    }

    fun getCurrencies() {
        viewModelScope.launch {
            getCurrenciesUseCase().collectLatest { _currencies.value = it }
        }
    }

    fun getGameModes() {
        viewModelScope.launch {
            getGameModesUseCase().collectLatest { _gameModes.value = it }
        }
    }

    fun getSeasons() {
        viewModelScope.launch {
            getSeasonsUseCase().collectLatest { _seasons.value = it }
        }
    }
}
