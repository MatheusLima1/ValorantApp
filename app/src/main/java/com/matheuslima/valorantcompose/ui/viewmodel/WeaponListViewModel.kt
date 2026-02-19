package com.matheuslima.valorantcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.domain.usecase.GetWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponListViewModel @Inject constructor(private val getWeaponsUseCase: GetWeaponsUseCase) :
    ViewModel() {

    private val _weapons: MutableStateFlow<BaseResponse<List<WeaponDomain>>> =
        MutableStateFlow(BaseResponse.Loading())

    val weapons: StateFlow<BaseResponse<List<WeaponDomain>>> = _weapons

    fun getWeapons(language: String? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            getWeaponsUseCase(language).collectLatest { response ->
                _weapons.value = response
            }
        }
    }

    init {
        getWeapons()
    }
}
