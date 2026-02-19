package com.matheuslima.valorantcompose.domain.mapper

import com.matheuslima.valorantcompose.data.response.entities.Agent
import com.matheuslima.valorantcompose.data.response.entities.Ability
import com.matheuslima.valorantcompose.data.response.entities.Role
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import com.matheuslima.valorantcompose.domain.model.AbilityDomain
import com.matheuslima.valorantcompose.domain.model.RoleDomain

fun Agent.toDomain(): AgentDomain {
    return AgentDomain(
        uuid = uuid ?: "",
        displayName = displayName ?: "",
        description = description ?: "",
        displayIcon = displayIcon ?: "",
        fullPortrait = fullPortraitV2 ?: fullPortrait,
        background = background,
        role = role?.toDomain(),
        abilities = abilities?.map { it.toDomain() } ?: emptyList(),
        backgroundGradientColors = backgroundGradientColors ?: emptyList()
    )
}

fun Role.toDomain(): RoleDomain {
    return RoleDomain(
        uuid = uuid,
        displayName = displayName,
        description = description,
        displayIcon = displayIcon
    )
}

fun Ability.toDomain(): AbilityDomain {
    return AbilityDomain(
        slot = slot,
        displayName = displayName,
        description = description,
        displayIcon = displayIcon
    )
}
