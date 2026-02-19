package com.matheuslima.valorantcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.matheuslima.valorantcompose.ui.navigation.ValorantAppNavGraph
import com.matheuslima.valorantcompose.ui.navigation.ValorantBottomNavigation
import com.matheuslima.valorantcompose.ui.theme.ValorantComposeTheme
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantComposeTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        ValorantBottomNavigation(navController = navController)
                    },
                    containerColor = ValorantDark,
                    content = { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            ValorantAppNavGraph(navController = navController)
                        }
                    }
                )
            }
        }
    }
}