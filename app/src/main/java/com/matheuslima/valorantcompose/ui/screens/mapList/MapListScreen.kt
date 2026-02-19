package com.matheuslima.valorantcompose.ui.screens.mapList

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.domain.model.MapDomain
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantWhite
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import com.matheuslima.valorantcompose.ui.viewmodel.MapListViewModel

@Composable
fun MapListScreen(navController: NavController, viewModel: MapListViewModel = hiltViewModel()) {
    val mapsResponse by viewModel.maps.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (mapsResponse) {
            is BaseResponse.Loading<*> -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success<*> -> {
                val maps = (mapsResponse as BaseResponse.Success<List<MapDomain>>).data
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        Text(
                            text = "SITES",
                            color = ValorantWhite,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                    items(items = maps) { map ->
                        MapItem(map, onClick = {
                            navController.navigate("${com.matheuslima.valorantcompose.ui.navigation.Routes.MAP_DETAIL_SCREEN}/${map.uuid}")
                        })
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
fun MapItem(map: MapDomain, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp, 
                Brush.verticalGradient(listOf(CyberCyan.copy(alpha = 0.5f), Color.Transparent)),
                RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = map.splash,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f))))
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = map.displayName.uppercase(),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Black
            )
            map.coordinates?.let {
                Text(
                    text = it,
                    color = CyberCyan,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
