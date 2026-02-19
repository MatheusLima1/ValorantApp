package com.matheuslima.valorantcompose.domain.mapper

import com.matheuslima.valorantcompose.data.response.entities.*
import com.matheuslima.valorantcompose.domain.model.*

fun PlayerTitle.toDomain() = TitleDomain(
    uuid = uuid,
    displayName = displayName ?: "",
    titleText = titleText ?: ""
)

fun PlayerCard.toDomain(): PlayerCardDomain = PlayerCardDomain(
    uuid = uuid,
    displayName = displayName,
    displayIcon = displayIcon,
    smallArt = smallArt,
    wideArt = wideArt,
    largeArt = largeArt ?: displayIcon
)

fun Currency.toDomain(): CurrencyDomain = CurrencyDomain(
    uuid = uuid,
    displayName = displayName,
    displayNameSingular = displayNameSingular,
    displayIcon = displayIcon,
    largeIcon = largeIcon
)

fun GameMode.toDomain(): GameModeDomain = GameModeDomain(
    uuid = uuid,
    displayName = displayName,
    duration = duration,
    allowsMatchTimeouts = allowsMatchTimeouts,
    isTeamVoiceAllowed = isTeamVoiceAllowed,
    isMinimapHidden = isMinimapHidden,
    supportsMidQueues = supportsMidQueues,
    economyConfig = economyConfig?.let {
        EconomyConfigDomain(it.maxTheoreticalEconomy, it.maxTheoreticalWeaponCosts)
    }
)

fun Season.toDomain(): SeasonDomain = SeasonDomain(
    uuid = uuid,
    displayName = displayName,
    type = type,
    startTime = startTime,
    endTime = endTime,
    parentUuid = parentUuid
)
