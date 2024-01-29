package com.example.sdui.data.dto

abstract class BaseDto(val viewType: String)

data class SectionsDto(
    val sectionCard: SectionCardDto? = null,
    val sectionBanner: SectionBannerDto? = null,
    val sectionAppBar: SectionAppBarDto? = null,
    val sectionList: SectionListDto? = null
)

data class SectionCardDto(
    val title: String? = null,
    val id: Int? = null,
    val url: String? = null,
    val description: String? = null,
    val price: String? = null
) : BaseDto("VIEW_TYPE_CARD")

data class SectionBannerDto(
    val body: List<BannerBodyDto>? = null
) : BaseDto("VIEW_TYPE_BANNER")

data class SectionAppBarDto(
    val title: String? = null
) : BaseDto("VIEW_TYPE_APP_BAR")

data class SectionListDto(
    val design: DesignDto? = null,
    val body: List<ListBodyDto>? = null
) : BaseDto("VIEW_TYPE_VERTICAL")