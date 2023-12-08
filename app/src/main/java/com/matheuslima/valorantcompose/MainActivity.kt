package com.matheuslima.valorantcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.matheuslima.utilities.LoggerProvider
import com.matheuslima.utilities.LoggerProviderImpl
import com.matheuslima.valorantcompose.ui.navigation.ValorantAppNavGraph
import com.matheuslima.valorantcompose.ui.theme.ValorantComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), LoggerProvider by LoggerProviderImpl() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerLifecycleOwner(TAG, this)

        setContent {
            ValorantComposeTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text("ValorantApp") },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary
                        )
                    )
                },
                    content = {innerPadding->
                        Surface(
                            modifier = Modifier.padding(innerPadding),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            AppEntryPoint()
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
fun AppEntryPoint() {
    ValorantAppNavGraph()
}