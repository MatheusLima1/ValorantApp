package com.matheuslima.valorantcompose.data.response.entities

data class MapResponse(
    val `data`: List<ValorantMap>,
    val status: Int
)

data class ValorantMap(
    val uuid: String,
    val displayName: String,
    val narrativeDescription: String?,
    val tacticalDescription: String?,
    val coordinates: String?,
    val displayIcon: String?,
    val listViewIcon: String?,
    val splash: String,
    val assetPath: String,
    val mapUrl: String,
    val xMultiplier: Double,
    val yMultiplier: Double,
    val xScalarToAdd: Double,
    val yScalarToAdd: Double
)
