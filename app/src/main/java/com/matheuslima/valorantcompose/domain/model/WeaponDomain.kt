package com.matheuslima.valorantcompose.domain.model

data class WeaponDomain(
    val uuid: String,
    val displayName: String,
    val category: String,
    val displayIcon: String,
    val cost: Int?,
    val fireRate: Double?,
    val magazineSize: Int?,
    val weaponStats: WeaponStatsDomain?,
    val shopData: ShopDataDomain?,
    val skins: List<WeaponSkinDomain>
)

data class WeaponStatsDomain(
    val fireRate: Double,
    val magazineSize: Int,
    val runSpeedMultiplier: Double,
    val reloadTimeSeconds: Double,
    val firstBulletAccuracy: Double,
    val shotgunPelletCount: Int
)

data class ShopDataDomain(
    val cost: Int,
    val category: String,
    val categoryText: String
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
    val splash: String,
    val tacticalDescription: String?,
    val narrativeDescription: String?
)
