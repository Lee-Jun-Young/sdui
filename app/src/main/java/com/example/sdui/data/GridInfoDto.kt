package com.example.sdui.data

import com.google.gson.annotations.SerializedName

data class GridInfoDto(
    @SerializedName("row")
    val row: Int,
    @SerializedName("col")
    val col: Int,
    @SerializedName("orientation")
    val orientation: String
)
