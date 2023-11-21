package com.matheuslima.valorantcompose.ui.screens.agentList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.data.response.entities.Agent
import com.matheuslima.valorantcompose.ui.helper.ColorGradientHelper.transformListColorStringInListColor

@Composable
fun AgentListItem(
    agent: Agent
) {
    val brush = agent.backgroundGradientColors?.let {
        Brush.horizontalGradient(transformListColorStringInListColor(it))
    }
    ConstraintLayout(
        modifier = Modifier
            .background(shape = RectangleShape, brush = brush!!)
            .fillMaxSize()
    ) {
        val backgroundImageRef = createRef()
        val displayIconRef = createRef()
        val surface = createRef()

        AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(agent.background)
            .crossfade(true)
            .placeholder(R.drawable.background_icon_gekko)
            .build(),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(backgroundImageRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })

        AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(agent.displayIcon)
            .crossfade(true)
            .placeholder(R.drawable.displayicon_gekko)
            .build(),
            contentDescription = "display icon image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.constrainAs(displayIconRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })

        Surface(color = Color.Black.copy(alpha = 0.6f), modifier = Modifier
            .constrainAs(surface) {
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            .clip(RoundedCornerShape(10.dp))) {
            Text(
                text = agent.displayName!!,
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Monospace,
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Preview
@Composable
fun AgentItemPreview() {
    val gradients = listOf("c7f458ff", "d56324ff", "3a2656ff", "3a7233ff")

    AgentListItem(
        agent = Agent(
            displayName = "Gekko",
            displayIcon = "https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/displayicon.png",
            background = "https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/background.png",
            backgroundGradientColors = gradients
        )
    )
}