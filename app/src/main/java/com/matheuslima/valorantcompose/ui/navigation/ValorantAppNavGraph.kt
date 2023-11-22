package com.matheuslima.valorantcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.matheuslima.valorantcompose.ui.screens.agentList.AgentListScreen
import com.matheuslima.valorantcompose.ui.screens.homeScreen.HomeScreen
import com.matheuslima.valorantcompose.ui.screens.notImplementedYetScreen.NotImplementedYetScreen

@Composable
fun ValorantAppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
        composable(Routes.AGENT_LIST_SCREEN){
            AgentListScreen(navController = navController)
        }
        composable(Routes.NOT_IMPLEMENTED_YET_SCREEN){
            NotImplementedYetScreen()
        }
    }
}