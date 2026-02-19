package com.matheuslima.valorantcompose.ui.screens.mapDetail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.domain.model.MapDomain
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.viewmodel.MapDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapDetailScreen(
    mapUuid: String,
    navController: NavController,
    viewModel: MapDetailViewModel = hiltViewModel()
) {
    val mapResponse by viewModel.map.collectAsState()

    LaunchedEffect(mapUuid) {
        viewModel.getMap(mapUuid)
    }

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (mapResponse) {
            is BaseResponse.Loading -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success -> {
                val map = (mapResponse as BaseResponse.Success).data
                MapDetailContent(map, navController)
            }
            is BaseResponse.Error -> {
                // Handle error
            }
        }

        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
        )
    }
}

@Composable
fun MapDetailContent(map: MapDomain, navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
    ) {
        // Map Splash
        Box(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            AsyncImage(
                model = map.splash,
                contentDescription = map.displayName,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, ValorantDark),
                        startY = 0f,
                        endY = 1000f
                    )
                )
            )
            
            Column(
                modifier = Modifier.align(Alignment.BottomStart).padding(24.dp)
            ) {
                Text(
                    text = map.coordinates ?: "LOCATED: UNKNOWN",
                    color = CyberCyan,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = map.displayName.uppercase(),
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Black
                )
            }
        }

        // Info Card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(GlassBlack)
                .border(1.dp, CyberCyan.copy(alpha = 0.3f), RoundedCornerShape(24.dp))
                .padding(24.dp)
        ) {
            Text(
                text = "TACTICAL DESCRIPTION",
                color = CyberCyan,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = map.tacticalDescription ?: "No tactical data available.",
                color = Color.White,
                fontSize = 18.sp,
                lineHeight = 26.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "NARRATIVE DATA",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = map.narrativeDescription ?: "No narrative data available.",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 16.sp,
                lineHeight = 24.sp
            )
            
            if (map.displayIcon != null) {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "MINIMAP",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                AsyncImage(
                    model = map.displayIcon,
                    contentDescription = "Minimap",
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
        
        Spacer(modifier = Modifier.height(100.dp))
    }
}
