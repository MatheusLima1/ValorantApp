package com.matheuslima.valorantcompose.data.response.entities

data class TitleResponse(
    val `data`: List<PlayerTitle>,
    val status: Int
)

data class PlayerTitle(
    val uuid: String,
    val displayName: String?,
    val titleText: String?,
    val isHiddenIfNotOwned: Boolean,
    val assetPath: String
)

data class SingleTitleResponse(
    val `data`: PlayerTitle,
    val status: Int
)
