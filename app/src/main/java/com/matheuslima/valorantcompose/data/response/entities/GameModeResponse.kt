package com.matheuslima.valorantcompose.data.response.entities

data class GameModeResponse(
    val `data`: List<GameMode>,
    val status: Int
)

data class GameMode(
    val uuid: String,
    val displayName: String,
    val duration: String?,
    val economyConfig: EconomyConfig?,
    val allowsMatchTimeouts: Boolean,
    val isTeamVoiceAllowed: Boolean,
    val isMinimapHidden: Boolean,
    val supportsMidQueues: Boolean,
    val maximumQueueSize: Int,
    val minimumQueueSize: Int,
    val gameFeatureOverrides: List<GameFeatureOverride>?,
    val gameRuleConfigOverrides: List<GameRuleConfigOverride>?,
    val assetPath: String
)

data class EconomyConfig(
    val gridWidth: Int,
    val gridHeight: Int,
    val maxTheoreticalEconomy: Int,
    val maxTheoreticalWeaponCosts: Int
)

data class GameFeatureOverride(
    val featureName: String,
    val state: Boolean
)

data class GameRuleConfigOverride(
    val ruleName: String,
    val state: String
)

data class SingleGameModeResponse(
    val `data`: GameMode,
    val status: Int
)
