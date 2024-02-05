package com.example.sdui.util

import android.annotation.SuppressLint
import android.content.Context
import com.example.sdui.R
import kotlin.math.roundToInt

fun toPx(context: Context, dp: Int): Int {
    val density = context.resources.displayMetrics.density
    return (dp.toFloat() * density).roundToInt()
}

fun toPriceFormat(price: String): String {
    return price.replace(Regex("(\\d)(?=(\\d{3})+\$)"), "\$1,") + "원"
}

@SuppressLint("DiscouragedApi")
fun getImageRes(context: Context, imgUrl: String): Int {
    val drawableResId = context.resources.getIdentifier(imgUrl, "drawable", context.packageName)
    return if (drawableResId != 0) drawableResId else R.drawable.ic_bg_2
}