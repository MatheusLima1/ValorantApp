package com.matheuslima.valorantcompose.domain.model

data class WeaponDomain(
    val uuid: String,
    val displayName: String,
    val category: String,
    val displayIcon: String,
    val cost: Int?,
    val fireRate: Double?,
    val magazineSize: Int?,
    val skins: List<WeaponSkinDomain>
)

data class WeaponSkinDomain(
    val uuid: String,
    val displayName: String,
    val displayIcon: String?
)

data class MapDomain(
    val uuid: String,
    val displayName: String,
    val coordinates: String?,
    val displayIcon: String?,
    val splash: String
)
