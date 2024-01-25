package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

data class SectionItemDto(
    @SerializedName("viewType")
    val viewType: String,
    @SerializedName("header")
    val header: HeaderDataDto? = null,
    @SerializedName("grid_info")
    val gridInfo: GridInfoDto? = null,
    @SerializedName("design")
    val design: DesignDto? = null,
    @SerializedName("body")
    val body: List<BodyDataDto>? = null
)