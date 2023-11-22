package com.matheuslima.valorantcompose.ui.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.navigation.Routes.AGENT_LIST_SCREEN
import com.matheuslima.valorantcompose.ui.navigation.Routes.NOT_IMPLEMENTED_YET_SCREEN
import com.matheuslima.valorantcompose.ui.screens.homeScreen.components.HomeScreenItem

const val TAG = "HOMESCREEN"

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HomeScreenItem(
            R.drawable.agents_list_background,
            stringResource(R.string.agents)
        ) { navController.navigate(AGENT_LIST_SCREEN) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            R.drawable.buddie_list_background,
            stringResource(R.string.buddies)
        ) { navController.navigate(NOT_IMPLEMENTED_YET_SCREEN) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            R.drawable.bundle_list_background,
            stringResource(R.string.bundles)
        ) { navController.navigate(NOT_IMPLEMENTED_YET_SCREEN) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            R.drawable.competitive_tier_list_background,
            stringResource(R.string.tiers)
        ) { navController.navigate(NOT_IMPLEMENTED_YET_SCREEN) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            R.drawable.contract_list_background,
            stringResource(R.string.contracts)
        ) { navController.navigate(NOT_IMPLEMENTED_YET_SCREEN) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            R.drawable.events_list_background,
            stringResource(R.string.events)
        ) { navController.navigate(NOT_IMPLEMENTED_YET_SCREEN) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            R.drawable.maps_list_background,
            stringResource(R.string.maps)
        ) { navController.navigate(NOT_IMPLEMENTED_YET_SCREEN) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            R.drawable.weapons_list_background,
            stringResource(R.string.weapons)
        ) { navController.navigate(NOT_IMPLEMENTED_YET_SCREEN) }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}