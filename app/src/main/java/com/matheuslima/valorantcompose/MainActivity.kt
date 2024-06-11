package com.matheuslima.valorantcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.matheuslima.utilities.LoggerProvider
import com.matheuslima.utilities.LoggerProviderImpl
import com.matheuslima.valorantcompose.ui.navigation.ValorantAppNavGraph
import com.matheuslima.valorantcompose.ui.theme.Purple80
import com.matheuslima.valorantcompose.ui.theme.ValorantComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity(), LoggerProvider by LoggerProviderImpl() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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