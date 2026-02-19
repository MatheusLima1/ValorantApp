package com.matheuslima.valorantcompose.domain.model

data class AgentDomain(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val fullPortrait: String?,
    val background: String?,
    val role: RoleDomain?,
    val abilities: List<AbilityDomain>,
    val backgroundGradientColors: List<String>
)

data class RoleDomain(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String
)

data class AbilityDomain(
    val slot: String,
    val displayName: String,
    val description: String,
    val displayIcon: String?
)
