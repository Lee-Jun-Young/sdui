package com.example.sdui.util

import android.content.Context
import kotlin.math.roundToInt

fun toPx(context: Context, dp: Int): Int {
    val density = context.resources.displayMetrics.density
    return (dp.toFloat() * density).roundToInt()
}

fun toPriceFormat(price: String): String {
    return price.replace(Regex("(\\d)(?=(\\d{3})+\$)"), "\$1,") + "원"
}