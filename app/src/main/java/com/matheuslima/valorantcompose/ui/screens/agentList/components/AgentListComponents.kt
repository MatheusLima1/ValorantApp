package com.matheuslima.valorantcompose.ui.screens.agentList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.matheuslima.valorantcompose.domain.model.AgentDomain
import com.matheuslima.valorantcompose.ui.theme.CyberCyan
import com.matheuslima.valorantcompose.ui.theme.ValorantRed
import com.matheuslima.valorantcompose.ui.theme.GlassBlack

@Composable
fun AgentListItem(
    agent: AgentDomain,
    onItemClick: (AgentDomain) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(agent) }
    ) {
        // Background Image with Blur
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(agent.background)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(10.dp)
        )

        // Dark Overlay for contrast
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )

        // Agent Portrait
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(agent.fullPortrait)
                .crossfade(true)
                .build(),
            contentDescription = agent.displayName,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp)
        )

        // Glassmorphism Card Info
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(24.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(GlassBlack)
                .border(
                    width = 1.dp,
                    brush = Brush.verticalGradient(
                        listOf(CyberCyan.copy(alpha = 0.5f), Color.Transparent)
                    ),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = agent.role?.displayIcon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = agent.role?.displayName?.uppercase() ?: "",
                    color = CyberCyan,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
            }
            
            Text(
                text = agent.displayName.uppercase(),
                color = Color.White,
                fontSize = 42.sp,
                fontWeight = FontWeight.Black,
                letterSpacing = (-1).sp
            )
            
            Text(
                text = agent.description,
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 14.sp,
                maxLines = 3,
                lineHeight = 20.sp
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // View Details Button (Mock)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(ValorantRed)
                    .padding(horizontal = 24.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "VIEW DOSSIER",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}