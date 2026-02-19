package com.matheuslima.valorantcompose.data.response.entities

data class WeaponResponse(
    val `data`: List<Weapon>,
    val status: Int
)

data class Weapon(
    val uuid: String,
    val displayName: String,
    val category: String,
    val displayIcon: String,
    val weaponStats: WeaponStats?,
    val shopData: ShopData?,
    val skins: List<WeaponSkin>
)

data class WeaponStats(
    val fireRate: Double,
    val magazineSize: Int,
    val runSpeedMultiplier: Double,
    val equipTimeSeconds: Double,
    val reloadTimeSeconds: Double,
    val firstBulletAccuracy: Double,
    val shotgunPelletCount: Int,
    val wallPenetration: String,
    val feature: String?,
    val fireMode: String?,
    val altFireType: String?,
    val adsStats: AdsStats?,
    val damageRanges: List<DamageRange>
)

data class AdsStats(
    val zoomMultiplier: Double,
    val fireRate: Double,
    val runSpeedMultiplier: Double,
    val burstCount: Int,
    val firstBulletAccuracy: Double
)

data class DamageRange(
    val rangeStartMeters: Int,
    val rangeEndMeters: Int,
    val headDamage: Double,
    val bodyDamage: Double,
    val legDamage: Double
)

data class ShopData(
    val cost: Int,
    val category: String,
    val categoryText: String,
    val canBeTrashed: Boolean,
    val image: String?,
    val newImage: String?,
    val newImage2: String?,
    val assetPath: String
)

data class WeaponSkin(
    val uuid: String,
    val displayName: String,
    val themeUuid: String,
    val contentTierUuid: String?,
    val displayIcon: String?,
    val wallpaper: String?,
    val assetPath: String,
    val chromatic_assetPath: String?,
    val levels: List<WeaponSkinLevel>,
    val chromas: List<WeaponSkinChroma>
)

data class WeaponSkinLevel(
    val uuid: String,
    val displayName: String,
    val levelItem: String?,
    val displayIcon: String?,
    val streamedVideo: String?,
    val assetPath: String
)

data class WeaponSkinChroma(
    val uuid: String,
    val displayName: String,
    val displayIcon: String?,
    val fullRender: String,
    val swatch: String?,
    val streamedVideo: String?,
    val assetPath: String
)
