package com.matheuslima.valorantcompose.domain.mapper

import com.matheuslima.valorantcompose.data.response.entities.Weapon
import com.matheuslima.valorantcompose.data.response.entities.WeaponSkin
import com.matheuslima.valorantcompose.data.response.entities.ValorantMap
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.domain.model.WeaponSkinDomain
import com.matheuslima.valorantcompose.domain.model.MapDomain

fun Weapon.toDomain(): WeaponDomain {
    return WeaponDomain(
        uuid = uuid,
        displayName = displayName,
        category = category.substringAfterLast("::"),
        displayIcon = displayIcon,
        cost = shopData?.cost,
        fireRate = weaponStats?.fireRate,
        magazineSize = weaponStats?.magazineSize,
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
        splash = splash
    )
}
