package com.matheuslima.valorantcompose.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.navigation.AgentListScreen
import com.matheuslima.valorantcompose.ui.navigation.NotImplementedYetScreen
import com.matheuslima.valorantcompose.ui.screens.homeScreen.components.HomeScreenItem
import com.matheuslima.valorantcompose.ui.theme.Purple80
import com.matheuslima.valorantcompose.ui.theme.setStatusBarColor

const val TAG = "HOMESCREEN"

@Composable
fun HomeScreen(navController: NavController, windowSize: WindowSizeClass?) {
    setStatusBarColor(Purple80)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HomeScreenItem(
            stringResource(R.string.agents)
        ) { navController.navigate(AgentListScreen) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            stringResource(R.string.buddies)
        ) { navController.navigate(NotImplementedYetScreen) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            stringResource(R.string.bundles)
        ) { navController.navigate(NotImplementedYetScreen) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            stringResource(R.string.tiers)
        ) { navController.navigate(NotImplementedYetScreen) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            stringResource(R.string.contracts)
        ) { navController.navigate(NotImplementedYetScreen) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            stringResource(R.string.events)
        ) { navController.navigate(NotImplementedYetScreen) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            stringResource(R.string.maps)
        ) { navController.navigate(NotImplementedYetScreen) }
        Spacer(modifier = Modifier.size(5.dp))
        HomeScreenItem(
            stringResource(R.string.weapons)
        ) { navController.navigate(NotImplementedYetScreen) }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController, null)
}