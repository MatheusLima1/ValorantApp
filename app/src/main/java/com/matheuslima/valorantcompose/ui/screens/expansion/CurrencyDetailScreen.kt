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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.domain.model.CurrencyDomain
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantWhite
import com.matheuslima.valorantcompose.ui.viewmodel.ExpansionViewModel

@Composable
fun CurrencyDetailScreen(currencyUuid: String, viewModel: ExpansionViewModel = hiltViewModel()) {
    val currencyDetailResponse by viewModel.currencyDetail.collectAsState()

    LaunchedEffect(currencyUuid) {
        viewModel.getCurrencyDetail(currencyUuid)
    }

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (currencyDetailResponse) {
            is BaseResponse.Loading<*> -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success<*> -> {
                val currency = (currencyDetailResponse as BaseResponse.Success<CurrencyDomain>).data
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(48.dp))
                    
                    AsyncImage(
                        model = currency.largeIcon ?: currency.displayIcon,
                        contentDescription = currency.displayName,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(GlassBlack)
                            .border(1.dp, CyberCyan.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                            .padding(24.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "CURRENCY INFO",
                        color = CyberCyan,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )

                    Text(
                        text = currency.displayName.uppercase(),
                        color = ValorantWhite,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(GlassBlack)
                            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                            .padding(20.dp)
                    ) {
                        Column {
                            Text(
                                text = "SINGULAR NAME",
                                color = Color.White.copy(alpha = 0.5f),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = currency.displayNameSingular.uppercase(),
                                color = ValorantWhite,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
            is BaseResponse.Error<*> -> {
                // Handle error
            }
        }
    }
}
