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
    val smallArt: String,
    val wideArt: String,
    val largeArt: String
)

data class CurrencyDomain(
    val uuid: String,
    val displayName: String,
    val displayNameSingular: String,
    val displayIcon: String,
    val largeIcon: String?
)

data class GameModeDomain(
    val uuid: String,
    val displayName: String,
    val duration: String?,
    val allowsMatchTimeouts: Boolean,
    val isTeamVoiceAllowed: Boolean,
    val isMinimapHidden: Boolean,
    val supportsMidQueues: Boolean,
    val economyConfig: EconomyConfigDomain?
)

data class EconomyConfigDomain(
    val maxTheoreticalEconomy: Int,
    val maxTheoreticalWeaponCosts: Int
)

data class SeasonDomain(
    val uuid: String,
    val displayName: String,
    val type: String?,
    val startTime: String,
    val endTime: String,
    val parentUuid: String?
)
