package com.matheuslima.valorantcompose.data.response.entities

data class PlayerCardResponse(
    val `data`: List<PlayerCard>,
    val status: Int
)

data class PlayerCard(
    val uuid: String,
    val displayName: String,
    val isHiddenIfNotOwned: Boolean,
    val themeUuid: String?,
    val displayIcon: String,
    val smallArt: String,
    val wideArt: String,
    val largeArt: String,
    val assetPath: String
)

data class SinglePlayerCardResponse(
    val `data`: PlayerCard,
    val status: Int
)
