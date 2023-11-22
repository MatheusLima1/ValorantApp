package com.matheuslima.valorantcompose.ui.screens.errorScreens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.matheuslima.utilities.exceptions.BaseException
import com.matheuslima.utilities.exceptions.EmptyDataException
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.theme.Typography

@Composable
fun GeneralScreenErrorComponent(
    modifier: Modifier = Modifier,
    animationPath: Int,
    exception: BaseException
) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout {
            val animationRef = createRef()
            val textTitleRef = createRef()
            val textDescriptionRef = createRef()
            LottieAnimationComponent(rawUrl = animationPath,
                modifier = Modifier
                    .wrapContentHeight()
                    .size(400.dp)
                    .constrainAs(animationRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    })
            Text(text = exception.message!!,
                fontStyle = Typography.titleLarge.fontStyle,
                fontSize = Typography.titleLarge.fontSize,
                fontFamily = Typography.titleLarge.fontFamily,
                fontWeight = Typography.titleLarge.fontWeight,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(textTitleRef) {
                        start.linkTo(animationRef.start)
                        end.linkTo(animationRef.end)
                        top.linkTo(animationRef.bottom)
                        bottom.linkTo(parent.bottom)
                    })

            Text(text = stringResource(R.string.please_try_again_later),
                fontStyle = Typography.bodyLarge.fontStyle,
                fontSize = Typography.bodyLarge.fontSize,
                fontFamily = Typography.bodyLarge.fontFamily,
                fontWeight = Typography.bodyLarge.fontWeight,
                color = Color.Black,
                modifier = Modifier
                    .constrainAs(textDescriptionRef) {
                        start.linkTo(textTitleRef.start)
                        end.linkTo(textTitleRef.end)
                        top.linkTo(textTitleRef.bottom, 10.dp)
                    })
        }
    }
}

@Composable
@Preview
fun GeneralScreenErrorComponentPreview() {
    GeneralScreenErrorComponent(animationPath = R.raw.tomato_typing, exception = EmptyDataException())
}