package com.matheuslima.valorantcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.domain.usecase.GetWeaponUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponDetailViewModel @Inject constructor(
    private val getWeaponUseCase: GetWeaponUseCase
) : ViewModel() {

    private val _weapon: MutableStateFlow<BaseResponse<WeaponDomain>> = MutableStateFlow(BaseResponse.Loading())
    val weapon: StateFlow<BaseResponse<WeaponDomain>> = _weapon

    fun getWeapon(uuid: String) {
        viewModelScope.launch {
            getWeaponUseCase(uuid).collectLatest { response ->
                _weapon.value = response
            }
        }
    }
}
