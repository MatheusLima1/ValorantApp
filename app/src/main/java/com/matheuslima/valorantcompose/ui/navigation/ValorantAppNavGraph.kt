package com.matheuslima.valorantcompose.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.matheuslima.valorantcompose.ui.screens.weaponDetail.WeaponDetailScreen
import com.matheuslima.valorantcompose.ui.screens.mapDetail.MapDetailScreen
import com.matheuslima.valorantcompose.ui.screens.agentList.AgentListScreen
import com.matheuslima.valorantcompose.ui.screens.agentDetail.AgentDetailScreen
import com.matheuslima.valorantcompose.ui.screens.homeScreen.HomeScreen
import com.matheuslima.valorantcompose.ui.screens.weaponList.WeaponListScreen
import com.matheuslima.valorantcompose.ui.screens.mapList.MapListScreen

@Composable
fun ValorantAppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
        composable(Routes.AGENT_LIST_SCREEN) {
            AgentListScreen(navController = navController)
        }
        composable(Routes.WEAPON_LIST_SCREEN) {
            WeaponListScreen(navController = navController)
        }
        composable(Routes.MAP_LIST_SCREEN) {
            MapListScreen(navController = navController)
        }
        composable(
            route = "${Routes.AGENT_DETAIL_SCREEN}/{agentUuid}",
            arguments = listOf(
                androidx.navigation.navArgument("agentUuid") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val agentUuid = backStackEntry.arguments?.getString("agentUuid") ?: ""
            AgentDetailScreen(agentUuid = agentUuid, navController = navController)
        }
        composable(
            route = "${Routes.WEAPON_DETAIL_SCREEN}/{weaponUuid}",
            arguments = listOf(
                androidx.navigation.navArgument("weaponUuid") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val weaponUuid = backStackEntry.arguments?.getString("weaponUuid") ?: ""
            WeaponDetailScreen(weaponUuid = weaponUuid, navController = navController)
        }
        composable(
            route = "${Routes.MAP_DETAIL_SCREEN}/{mapUuid}",
            arguments = listOf(
                androidx.navigation.navArgument("mapUuid") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val mapUuid = backStackEntry.arguments?.getString("mapUuid") ?: ""
            MapDetailScreen(mapUuid = mapUuid, navController = navController)
        }
    }
}

@Composable
fun PlaceholderScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = title, color = Color.White)
    }
}