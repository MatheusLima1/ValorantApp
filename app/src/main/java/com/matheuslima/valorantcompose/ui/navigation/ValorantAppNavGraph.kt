package com.matheuslima.valorantcompose.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.matheuslima.valorantcompose.ui.screens.agentList.AgentListScreen
import com.matheuslima.valorantcompose.ui.screens.homeScreen.HomeScreen
import com.matheuslima.valorantcompose.ui.screens.notImplementedYetScreen.NotImplementedYetScreen

@Composable
fun ValorantAppNavGraph(windowSize: WindowSizeClass) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> {
            HomeScreen(navController = navController, windowSize)
        }
        composable<AgentListScreen>{
            AgentListScreen(navController = navController, windowSize)
        }
        composable<NotImplementedYetScreen>{
            NotImplementedYetScreen()
        }
    }
}