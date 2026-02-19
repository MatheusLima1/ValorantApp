package com.matheuslima.valorantcompose.ui.screens.weaponList

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
import com.matheuslima.valorantcompose.domain.model.WeaponDomain
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.GlassBlack
import com.matheuslima.valorantcompose.ui.theme.ValorantDark
import com.matheuslima.valorantcompose.ui.theme.ValorantWhite
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import com.matheuslima.valorantcompose.ui.viewmodel.WeaponListViewModel

@Composable
fun WeaponListScreen(navController: NavController, viewModel: WeaponListViewModel = hiltViewModel()) {
    val weaponsResponse by viewModel.weapons.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(ValorantDark)) {
        when (weaponsResponse) {
            is BaseResponse.Loading<*> -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }
            is BaseResponse.Success<*> -> {
                val weapons = (weaponsResponse as BaseResponse.Success<List<WeaponDomain>>).data
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Text(
                            text = "ARSENAL",
                            color = ValorantWhite,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                    items(items = weapons) { weapon ->
                        WeaponItem(weapon, onClick = {
                            navController.navigate("${com.matheuslima.valorantcompose.ui.navigation.Routes.WEAPON_DETAIL_SCREEN}/${weapon.uuid}")
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
fun WeaponItem(weapon: WeaponDomain, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(GlassBlack)
            .border(
                1.dp, 
                Brush.horizontalGradient(listOf(CyberCyan.copy(alpha = 0.3f), Color.Transparent)),
                RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = weapon.category.uppercase(),
                    color = CyberCyan,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
                Text(
                    text = weapon.displayName.uppercase(),
                    color = ValorantWhite,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                )
                weapon.cost?.let {
                    Text(
                        text = "¤ $it",
                        color = Color.Yellow.copy(alpha = 0.8f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            AsyncImage(
                model = weapon.displayIcon,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(120.dp)
            )
        }
    }
}
