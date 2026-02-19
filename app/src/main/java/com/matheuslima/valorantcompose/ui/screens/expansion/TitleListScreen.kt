package com.matheuslima.valorantcompose.ui.screens.expansion

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantWhite
import com.matheuslima.valorantcompose.ui.viewmodel.ExpansionViewModel

@Composable
fun TitleListScreen(navController: NavController, viewModel: ExpansionViewModel = hiltViewModel()) {
    val titlesResponse by viewModel.titles.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getTitles()
    }

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (titlesResponse) {
            is BaseResponse.Loading -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success -> {
                val titles = (titlesResponse as BaseResponse.Success).data.filter { it.displayName.isNotBlank() }
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        Text(
                            text = "PLAYER TITLES",
                            color = ValorantWhite,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                    items(titles) { title ->
                        TitleItem(title.displayName)
                    }
                }
            }
            is BaseResponse.Error<*> -> {
                // Handle error
            }
        }
    }
}

@Composable
fun TitleItem(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(GlassBlack)
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = name.uppercase(),
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .width(4.dp)
                .height(16.dp)
                .background(CyberCyan)
        )
    }
}
