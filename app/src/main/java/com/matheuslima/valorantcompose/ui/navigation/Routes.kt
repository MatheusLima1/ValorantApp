package com.matheuslima.valorantcompose.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreen
@Serializable
object AgentListScreen
@Serializable
data class AgentDetailScreen(val uuid: String)
@Serializable
object NotImplementedYetScreen