package com.matheuslima.valorantcompose.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantRed

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : BottomNavItem(Routes.HOME_SCREEN, Icons.Default.Home, "Home")
    object Agents : BottomNavItem(Routes.AGENT_LIST_SCREEN, Icons.Default.Person, "Agents")
    object Weapons : BottomNavItem(Routes.WEAPON_LIST_SCREEN, Icons.Default.List, "Weapons")
    object Maps : BottomNavItem(Routes.MAP_LIST_SCREEN, Icons.Default.LocationOn, "Maps")
}

@Composable
fun ValorantBottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Agents,
        BottomNavItem.Weapons,
        BottomNavItem.Maps
    )
    NavigationBar(
        containerColor = ValorantDark,
        contentColor = CyberCyan
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ValorantRed,
                    selectedTextColor = ValorantRed,
                    unselectedIconColor = CyberCyan,
                    unselectedTextColor = CyberCyan,
                    indicatorColor = ValorantDark
                )
            )
        }
    }
}
