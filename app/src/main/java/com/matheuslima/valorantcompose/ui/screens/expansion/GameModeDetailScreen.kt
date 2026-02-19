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
import com.matheuslima.valorantcompose.domain.model.GameModeDomain
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantWhite
import com.matheuslima.valorantcompose.ui.viewmodel.ExpansionViewModel

@Composable
fun GameModeDetailScreen(modeUuid: String, viewModel: ExpansionViewModel = hiltViewModel()) {
    val modeDetailResponse by viewModel.gameModeDetail.collectAsState()

    LaunchedEffect(modeUuid) {
        viewModel.getGameModeDetail(modeUuid)
    }

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (modeDetailResponse) {
            is BaseResponse.Loading<*> -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success<*> -> {
                val mode = (modeDetailResponse as BaseResponse.Success<GameModeDomain>).data
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(24.dp)
                ) {
                    Text(
                        text = "GAME MODE",
                        color = CyberCyan,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                    Text(
                        text = mode.displayName.uppercase(),
                        color = ValorantWhite,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Black
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    GameModeInfoCard("RULES", listOf(
                        "ALLOWS MATCH TIMEOUTS" to mode.allowsMatchTimeouts.toString().uppercase(),
                        "TEAM VOICE ALLOWED" to mode.isTeamVoiceAllowed.toString().uppercase(),
                        "MINIMAP HIDDEN" to mode.isMinimapHidden.toString().uppercase(),
                        "SUPPORTS MID QUEUES" to mode.supportsMidQueues.toString().uppercase()
                    ))

                    Spacer(modifier = Modifier.height(16.dp))

                    mode.economyConfig?.let { economy ->
                        GameModeInfoCard("ECONOMY CONFIG", listOf(
                            "MAX THEORETICAL ECONOMY" to "${economy.maxTheoreticalEconomy}",
                            "MAX THEORETICAL WEAPON COSTS" to "${economy.maxTheoreticalWeaponCosts}"
                        ))
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
fun GameModeInfoCard(title: String, items: List<Pair<String, String>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(GlassBlack)
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            .padding(20.dp)
    ) {
        Text(
            text = title,
            color = CyberCyan,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        items.forEach { (label, value) ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = label, color = Color.White.copy(alpha = 0.5f), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text(text = value, color = ValorantWhite, fontSize = 11.sp, fontWeight = FontWeight.Black)
            }
        }
    }
}
