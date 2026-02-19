package com.matheuslima.valorantcompose.domain.mapper

import com.matheuslima.valorantcompose.data.response.entities.Weapon
import com.matheuslima.valorantcompose.data.response.entities.WeaponSkin
import com.matheuslima.valorantcompose.data.response.entities.ValorantMap
import com.matheuslima.valorantcompose.domain.model.*

fun Weapon.toDomain(): WeaponDomain {
    return WeaponDomain(
        uuid = uuid,
        displayName = displayName,
        category = category.substringAfterLast("::"),
        displayIcon = displayIcon,
        cost = shopData?.cost,
        fireRate = weaponStats?.fireRate,
        magazineSize = weaponStats?.magazineSize,
        weaponStats = weaponStats?.let {
            WeaponStatsDomain(
                fireRate = it.fireRate,
                magazineSize = it.magazineSize,
                runSpeedMultiplier = it.runSpeedMultiplier,
                reloadTimeSeconds = it.reloadTimeSeconds,
                firstBulletAccuracy = it.firstBulletAccuracy,
                shotgunPelletCount = it.shotgunPelletCount
            )
        },
        shopData = shopData?.let {
            ShopDataDomain(
                cost = it.cost,
                category = it.category,
                categoryText = it.categoryText
            )
        },
        skins = skins.map { it.toDomain() }
    )
}

fun WeaponSkin.toDomain(): WeaponSkinDomain {
    return WeaponSkinDomain(
        uuid = uuid,
        displayName = displayName,
        displayIcon = displayIcon
    )
}

fun ValorantMap.toDomain(): MapDomain {
    return MapDomain(
        uuid = uuid,
        displayName = displayName,
        coordinates = coordinates,
        displayIcon = displayIcon,
        splash = splash,
        tacticalDescription = tacticalDescription,
        narrativeDescription = narrativeDescription
    )
}
