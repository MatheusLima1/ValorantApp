package com.matheuslima.valorantcompose.domain.model

data class TitleDomain(
    val uuid: String,
    val displayName: String,
    val titleText: String
)

data class PlayerCardDomain(
    val uuid: String,
    val displayName: String,
    val displayIcon: String,
    val wideArt: String,
    val largeArt: String
)

data class CurrencyDomain(
    val uuid: String,
    val displayName: String,
    val displayIcon: String
)

data class GameModeDomain(
    val uuid: String,
    val displayName: String,
    val duration: String?
)

data class SeasonDomain(
    val uuid: String,
    val displayName: String,
    val type: String?,
    val startTime: String,
    val endTime: String
)
