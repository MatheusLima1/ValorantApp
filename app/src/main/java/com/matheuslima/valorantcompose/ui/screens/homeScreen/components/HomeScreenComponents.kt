package com.matheuslima.valorantcompose.ui.screens.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.matheuslima.valorantcompose.R

@Composable
fun HomeScreenItem(agentsListBackground: Int, title: String, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White)
            .clickable { onClick() }
    ) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val surface = createRef()
            Image(
                painter = painterResource(id = agentsListBackground),
                contentDescription = stringResource(id = R.string.agents_content_description),
                modifier = Modifier.fillMaxWidth()
            )
            Surface(color = Color.Black.copy(alpha = 0.6f),
                modifier = Modifier
                    .constrainAs(surface) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .clip(RoundedCornerShape(10.dp))) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}