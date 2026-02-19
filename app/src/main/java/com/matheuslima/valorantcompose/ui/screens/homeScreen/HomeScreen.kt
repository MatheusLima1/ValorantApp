package com.matheuslima.valorantcompose.ui.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.navigation.Routes.AGENT_LIST_SCREEN
import com.matheuslima.valorantcompose.ui.navigation.Routes.MAP_LIST_SCREEN
import com.matheuslima.valorantcompose.ui.navigation.Routes.WEAPON_LIST_SCREEN
import com.matheuslima.valorantcompose.ui.screens.homeScreen.components.HomeScreenItem
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantWhite

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ValorantDark)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderSection()
        
        Spacer(modifier = Modifier.height(24.dp))
        
        HomeScreenItem(
            backgroundImage = R.drawable.agents_list_background,
            title = stringResource(R.string.agents),
            subtitle = "CHOOSE YOUR RADIANT",
            onClick = { navController.navigate(AGENT_LIST_SCREEN) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        HomeScreenItem(
            backgroundImage = R.drawable.weapons_list_background,
            title = stringResource(R.string.weapons),
            subtitle = "CHOOSE YOUR ARSENAL",
            onClick = { navController.navigate(WEAPON_LIST_SCREEN) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        HomeScreenItem(
            backgroundImage = R.drawable.maps_list_background,
            title = stringResource(R.string.maps),
            subtitle = "EXPLORE THE THEATERS",
            onClick = { navController.navigate(MAP_LIST_SCREEN) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        HomeScreenItem(
            backgroundImage = R.drawable.buddie_list_background,
            title = "TITLES",
            subtitle = "CLAIM YOUR IDENTITY",
            onClick = { navController.navigate(com.matheuslima.valorantcompose.ui.navigation.Routes.TITLE_LIST_SCREEN) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        HomeScreenItem(
            backgroundImage = R.drawable.contract_list_background,
            title = "PLAYER CARDS",
            subtitle = "SHOW YOUR STYLE",
            onClick = { navController.navigate(com.matheuslima.valorantcompose.ui.navigation.Routes.PLAYER_CARD_LIST_SCREEN) }
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        HomeScreenItem(
            backgroundImage = R.drawable.bundle_list_background,
            title = "CURRENCIES",
            subtitle = "CHECK YOUR BALANCE",
            onClick = { navController.navigate(com.matheuslima.valorantcompose.ui.navigation.Routes.CURRENCY_LIST_SCREEN) }
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        HomeScreenItem(
            backgroundImage = R.drawable.events_list_background,
            title = "GAME MODES",
            subtitle = "CHOOSE YOUR PLAYSTYLE",
            onClick = { navController.navigate(com.matheuslima.valorantcompose.ui.navigation.Routes.GAME_MODE_LIST_SCREEN) }
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        HomeScreenItem(
            backgroundImage = R.drawable.competitive_tier_list_background,
            title = "SEASONS",
            subtitle = "TRACK THE PROTOCOL",
            onClick = { navController.navigate(com.matheuslima.valorantcompose.ui.navigation.Routes.SEASON_LIST_SCREEN) }
        )
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun HeaderSection() {
    Column {
        Text(
            text = "VALORANT",
            color = Color.Red,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 4.sp
        )
        Text(
            text = "PROTOCOL",
            color = ValorantWhite,
            fontSize = 36.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 2.sp
        )
        Text(
            text = "ACCESS LEVEL: RADIANT",
            color = CyberCyan.copy(alpha = 0.7f),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
    }
}