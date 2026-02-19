package com.matheuslima.valorantcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.MapDomain
import com.matheuslima.valorantcompose.domain.usecase.GetMapUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapDetailViewModel @Inject constructor(
    private val getMapUseCase: GetMapUseCase
) : ViewModel() {

    private val _map: MutableStateFlow<BaseResponse<MapDomain>> = MutableStateFlow(BaseResponse.Loading())
    val map: StateFlow<BaseResponse<MapDomain>> = _map

    fun getMap(uuid: String) {
        viewModelScope.launch {
            getMapUseCase(uuid).collectLatest { response ->
                _map.value = response
            }
        }
    }
}
