package com.matheuslima.valorantcompose.ui.screens.expansion

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.SeasonDomain
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantWhite
import com.matheuslima.valorantcompose.ui.viewmodel.ExpansionViewModel

@Composable
fun SeasonDetailScreen(seasonUuid: String, viewModel: ExpansionViewModel = hiltViewModel()) {
    val seasonDetailResponse by viewModel.seasonDetail.collectAsState()

    LaunchedEffect(seasonUuid) {
        viewModel.getSeasonDetail(seasonUuid)
    }

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (seasonDetailResponse) {
            is BaseResponse.Loading<*> -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success<*> -> {
                val season = (seasonDetailResponse as BaseResponse.Success<SeasonDomain>).data
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(24.dp)
                ) {
                    Text(
                        text = "SEASON INFO",
                        color = CyberCyan,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                    Text(
                        text = season.displayName.uppercase(),
                        color = ValorantWhite,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Black
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    GameModeInfoCard("TIMELINE", listOf(
                        "TYPE" to (season.type?.uppercase() ?: "UNKNOWN"),
                        "START DATE" to season.startTime.substringBefore("T"),
                        "END DATE" to season.endTime.substringBefore("T"),
                        "PARENT UUID" to (season.parentUuid?.uppercase() ?: "NONE")
                    ))
                }
            }
            is BaseResponse.Error<*> -> {
                // Handle error
            }
        }
    }
}
