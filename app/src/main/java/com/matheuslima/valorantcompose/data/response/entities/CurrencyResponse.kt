package com.matheuslima.valorantcompose.data.response.entities

data class CurrencyResponse(
    val `data`: List<Currency>,
    val status: Int
)

data class Currency(
    val uuid: String,
    val displayName: String,
    val displayNameSingular: String,
    val displayIcon: String,
    val largeIcon: String?,
    val assetPath: String
)

data class SingleCurrencyResponse(
    val `data`: Currency,
    val status: Int
)
