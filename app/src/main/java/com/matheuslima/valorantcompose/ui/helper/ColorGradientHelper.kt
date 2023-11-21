package com.matheuslima.valorantcompose.ui.helper

import android.graphics.Color.parseColor
import androidx.compose.ui.graphics.Color

object ColorGradientHelper {

    fun transformListColorStringInListColor(colorString: List<String>): List<Color> {
        val mutableList = mutableListOf<Color>()
        colorString.forEach {
            mutableList.add(transformColorStringOnColor(it))
        }
        return mutableList
    }

    private fun transformColorStringOnColor(colorString: String) =
        Color(parseColor("#$colorString"))
}