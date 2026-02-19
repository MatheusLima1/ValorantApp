package com.matheuslima.valorantcompose.domain.mapper

import com.matheuslima.valorantcompose.data.response.entities.*
import com.matheuslima.valorantcompose.domain.model.*

fun PlayerTitle.toDomain() = TitleDomain(
    uuid = uuid,
    displayName = displayName ?: "",
    titleText = titleText ?: ""
)

fun PlayerCard.toDomain() = PlayerCardDomain(
    uuid = uuid,
    displayName = displayName,
    displayIcon = displayIcon,
    wideArt = wideArt,
    largeArt = largeArt
)

fun Currency.toDomain() = CurrencyDomain(
    uuid = uuid,
    displayName = displayName,
    displayIcon = displayIcon
)

fun GameMode.toDomain() = GameModeDomain(
    uuid = uuid,
    displayName = displayName,
    duration = duration
)

fun Season.toDomain() = SeasonDomain(
    uuid = uuid,
    displayName = displayName,
    type = type,
    startTime = startTime,
    endTime = endTime
)
