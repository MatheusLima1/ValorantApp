package com.matheuslima.valorantcompose.ui.screens.notImplementedYetScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.matheuslima.utilities.exceptions.NotImplementedYetException
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.GeneralScreenErrorComponent

@Composable
fun NotImplementedYetScreen() {
    GeneralScreenErrorComponent(
        animationPath = R.raw.tomato_typing,
        exception = NotImplementedYetException(),
        title = "This is a future release"
    )
}

@Preview
@Composable
fun NotImplementedYetScreenPreview() {
    NotImplementedYetScreen()
}