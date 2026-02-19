package com.matheuslima.valorantcompose.ui.screens.weaponDetail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.viewmodel.WeaponDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeaponDetailScreen(
    weaponUuid: String,
    navController: NavController,
    viewModel: WeaponDetailViewModel = hiltViewModel()
) {
    val weaponResponse by viewModel.weapon.collectAsState()

    LaunchedEffect(weaponUuid) {
        viewModel.getWeapon(weaponUuid)
    }

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (weaponResponse) {
            is BaseResponse.Loading -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success -> {
                val weapon = (weaponResponse as BaseResponse.Success).data
                WeaponDetailContent(weapon, navController)
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
fun WeaponDetailContent(weapon: WeaponDomain, navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState).padding(top = 60.dp)
    ) {
        // Weapon Header
        Box(
            modifier = Modifier.fillMaxWidth().height(250.dp).padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = weapon.displayIcon,
                contentDescription = weapon.displayName,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

        // Stats Card
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
                text = weapon.category.substringAfterLast("::").uppercase(),
                color = CyberCyan,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
            Text(
                text = weapon.displayName.uppercase(),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            WeaponStatRow("FIRE RATE", "${weapon.weaponStats?.fireRate ?: "N/A"}")
            WeaponStatRow("MAGAZINE SIZE", "${weapon.weaponStats?.magazineSize ?: "N/A"}")
            WeaponStatRow("RELOAD TIME", "${weapon.weaponStats?.reloadTimeSeconds ?: "N/A"}s")
            WeaponStatRow("COST", "¤${weapon.shopData?.cost ?: 0}")

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "SKINS",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.height(120.dp)
            ) {
                items(weapon.skins) { skin ->
                    if (skin.displayIcon != null) {
                        SkinCard(skin.displayIcon, skin.displayName)
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun WeaponStatRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = Color.White.copy(alpha = 0.6f), fontSize = 12.sp)
        Text(text = value, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SkinCard(icon: String, name: String) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.05f))
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = icon,
            contentDescription = name,
            modifier = Modifier.weight(1f).fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Text(
            text = name,
            color = Color.White,
            fontSize = 10.sp,
            maxLines = 1,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
