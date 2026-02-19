package com.matheuslima.valorantcompose.data.response.entities

data class SeasonResponse(
    val `data`: List<Season>,
    val status: Int
)

data class Season(
    val uuid: String,
    val displayName: String,
    val type: String?,
    val startTime: String,
    val endTime: String,
    val parentUuid: String?,
    val assetPath: String
)

data class SingleSeasonResponse(
    val `data`: Season,
    val status: Int
)
