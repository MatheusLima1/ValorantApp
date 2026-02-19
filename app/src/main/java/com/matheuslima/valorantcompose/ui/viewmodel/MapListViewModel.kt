package com.matheuslima.valorantcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.MapDomain
import com.matheuslima.valorantcompose.domain.usecase.GetMapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapListViewModel @Inject constructor(private val getMapsUseCase: GetMapsUseCase) :
    ViewModel() {

    private val _maps: MutableStateFlow<BaseResponse<List<MapDomain>>> =
        MutableStateFlow(BaseResponse.Loading())

    val maps: StateFlow<BaseResponse<List<MapDomain>>> = _maps

    fun getMaps(language: String? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            getMapsUseCase(language).collectLatest { response ->
                _maps.value = response
            }
        }
    }

    init {
        getMaps()
    }
}
