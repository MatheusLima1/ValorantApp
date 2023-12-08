package com.matheuslima.valorantcompose.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun TitleTileCorner(title: String) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val surface = createRef()
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