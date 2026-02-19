package com.matheuslima.valorantcompose.domain.usecase

import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.domain.repository.WeaponsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeaponUseCase @Inject constructor(
    private val repository: WeaponsRepository
) {
    suspend operator fun invoke(weaponUuid: String, language: String? = null): Flow<BaseResponse<WeaponDomain>> {
        return repository.getWeaponByUuid(weaponUuid, language)
    }
}
