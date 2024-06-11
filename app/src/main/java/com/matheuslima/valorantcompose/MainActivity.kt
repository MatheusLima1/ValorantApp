package com.matheuslima.valorantcompose

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import com.matheuslima.utilities.LoggerProvider
import com.matheuslima.utilities.LoggerProviderImpl
import com.matheuslima.valorantcompose.ui.navigation.ValorantAppNavGraph
import com.matheuslima.valorantcompose.ui.theme.ValorantComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity(), LoggerProvider by LoggerProviderImpl() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        registerLifecycleOwner(TAG, this)

        setContent {
            ValorantComposeTheme {
                val windowSize = calculateWindowSizeClass(this)
                Scaffold(content = { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppEntryPoint(windowSize)
                    }
                })

            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}

@Composable
fun AppEntryPoint(windowSize: WindowSizeClass) {
    ValorantAppNavGraph(windowSize)
}