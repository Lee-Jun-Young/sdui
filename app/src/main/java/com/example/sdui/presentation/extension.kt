package com.example.sdui.presentation

import android.content.Context
import kotlin.math.roundToInt

fun toPx(context: Context, dp: Int): Int {
    val density = context.resources.displayMetrics.density
    return (dp.toFloat() * density).roundToInt()
}