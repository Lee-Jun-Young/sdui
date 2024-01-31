package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

data class ResponseDataDto(
    @SerializedName("sectionType")
    val sectionType: String,
    @SerializedName("sections")
    val sections: List<TypeDataDto>? = null
)

data class TypeDataDto(
    @SerializedName("viewType")
    val viewType: String? = null,
    @SerializedName("body")
    val body: Any? = null
)

data class SectionCardDto(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("price")
    val price: String? = null
)

data class SectionBannerDto(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("body")
    val body: List<BannerBodyDto>? = null
)


data class SectionAppBarDto(
    @SerializedName("title")
    val title: String? = null
)

data class SectionListDto(
    @SerializedName("design")
    val design: DesignDto? = null,
    @SerializedName("body")
    val body: List<ListBodyDto>? = null
)