package com.matheuslima.valorantcompose.ui.screens.expansion

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.navigation.Routes
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.PlaceholderScreen
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantWhite
import com.matheuslima.valorantcompose.ui.viewmodel.ExpansionViewModel

@Composable
fun PlayerCardListScreen(navController: NavController, viewModel: ExpansionViewModel = hiltViewModel()) {
    val cardsResponse by viewModel.playerCards.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getPlayerCards()
    }

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (cardsResponse) {
            is BaseResponse.Loading -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success -> {
                val cards = (cardsResponse as BaseResponse.Success).data
                Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                    Text(
                        text = "PLAYER CARDS",
                        color = ValorantWhite,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(cards) { card ->
                            PlayerCardItem(card.largeArt, card.displayName) {
                                navController.navigate("${Routes.PLAYER_CARD_DETAIL_SCREEN}/${card.uuid}")
                            }
                        }
                    }
                }
            }
            is BaseResponse.Error<*> -> {
                val errorMessage = (cardsResponse as BaseResponse.Error).error.message ?: "Unknown Error"
                PlaceholderScreen(message = "Error: $errorMessage")
            }
        }
    }
}

@Composable
fun PlayerCardItem(image: String, name: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(GlassBlack)
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = image,
            contentDescription = name,
            modifier = Modifier.aspectRatio(0.45f).fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = name.uppercase(),
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp),
            maxLines = 1
        )
    }
}
