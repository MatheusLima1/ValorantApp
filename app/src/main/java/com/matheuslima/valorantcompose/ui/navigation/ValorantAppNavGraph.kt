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
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.matheuslima.valorantcompose.ui.screens.weaponDetail.WeaponDetailScreen
import com.matheuslima.valorantcompose.ui.screens.mapDetail.MapDetailScreen
import com.matheuslima.valorantcompose.ui.screens.agentList.AgentListScreen
import com.matheuslima.valorantcompose.ui.screens.agentDetail.AgentDetailScreen
import com.matheuslima.valorantcompose.ui.screens.homeScreen.HomeScreen
import com.matheuslima.valorantcompose.ui.screens.weaponList.WeaponListScreen
import com.matheuslima.valorantcompose.ui.screens.mapList.MapListScreen
import com.matheuslima.valorantcompose.ui.screens.expansion.*
import com.matheuslima.valorantcompose.ui.screens.errorScreens.*
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.PlaceholderScreen

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
        composable(Routes.TITLE_LIST_SCREEN) {
            TitleListScreen(navController = navController)
        }
        composable(Routes.PLAYER_CARD_LIST_SCREEN) {
            PlayerCardListScreen(navController = navController)
        }
        composable(Routes.CURRENCY_LIST_SCREEN) {
            CurrencyListScreen(navController = navController)
        }
        composable(Routes.GAME_MODE_LIST_SCREEN) {
            GameModeListScreen(navController = navController)
        }
        composable(Routes.SEASON_LIST_SCREEN) {
            SeasonListScreen(navController = navController)
        }
        composable(
            route = "${Routes.PLAYER_CARD_DETAIL_SCREEN}/{cardUuid}",
            arguments = listOf(navArgument("cardUuid") { type = NavType.StringType })
        ) { backStackEntry ->
            val cardUuid = backStackEntry.arguments?.getString("cardUuid") ?: ""
            PlayerCardDetailScreen(cardUuid = cardUuid)
        }
        composable(
            route = "${Routes.CURRENCY_DETAIL_SCREEN}/{currencyUuid}",
            arguments = listOf(navArgument("currencyUuid") { type = NavType.StringType })
        ) { backStackEntry ->
            val currencyUuid = backStackEntry.arguments?.getString("currencyUuid") ?: ""
            CurrencyDetailScreen(currencyUuid = currencyUuid)
        }
        composable(
            route = "${Routes.GAME_MODE_DETAIL_SCREEN}/{modeUuid}",
            arguments = listOf(navArgument("modeUuid") { type = NavType.StringType })
        ) { backStackEntry ->
            val modeUuid = backStackEntry.arguments?.getString("modeUuid") ?: ""
            GameModeDetailScreen(modeUuid = modeUuid)
        }
        composable(
            route = "${Routes.SEASON_DETAIL_SCREEN}/{seasonUuid}",
            arguments = listOf(navArgument("seasonUuid") { type = NavType.StringType })
        ) { backStackEntry ->
            val seasonUuid = backStackEntry.arguments?.getString("seasonUuid") ?: ""
            SeasonDetailScreen(seasonUuid = seasonUuid)
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