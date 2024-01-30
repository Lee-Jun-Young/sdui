package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

abstract class TypeDataDto(
    val viewType: String
)

data class SectionCardDto(
    val title: String? = null,
    val id: Int? = null,
    val url: String? = null,
    val description: String? = null,
    val price: String? = null
) : TypeDataDto("VIEW_TYPE_CARD")

data class SectionBannerDto(
    val title: String? = null,
    val id: Int? = null
    /*
    @SerializedName("body")
    val body: List<BannerBodyDto>? = null
*/
) : TypeDataDto("VIEW_TYPE_BANNER")


data class SectionAppBarDto(
    val title: String? = null
) : TypeDataDto("VIEW_TYPE_APP_BAR")

data class SectionListDto(
    val design: DesignDto? = null,
    val body: List<ListBodyDto>? = null
) : TypeDataDto("VIEW_TYPE_LIST")