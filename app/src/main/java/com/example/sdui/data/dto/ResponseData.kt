package com.example.sdui.data.dto

data class ResponseDataDto(
    val sectionType: String,
    val sections: List<BaseBodyDto>? = null
)

abstract class BaseBodyDto(val viewType: String)

data class SectionCardDto(
    val body: SectionCardContentDto? = null
) : BaseBodyDto("VIEW_TYPE_CARD")

data class SectionCardContentDto(
    val title: String? = null,
    val id: Int? = null,
    val url: String? = null,
    val description: String? = null,
    val price: String? = null
)

data class SectionBannerDto(
    val body: SectionBannerContentDto? = null
) : BaseBodyDto("VIEW_TYPE_BANNER")

data class SectionBannerContentDto(
    val title: String? = null,
    val body: List<BannerBodyDto>? = null
)

data class SectionAppBarDto(
    val body: SectionAppBarContentDto? = null
) : BaseBodyDto("VIEW_TYPE_APP_BAR")

data class SectionAppBarContentDto(
    val title: String? = null,
)

data class SectionListDto(
    val body: SectionListContentDto? = null
) : BaseBodyDto("VIEW_TYPE_LIST")

data class SectionListContentDto(
    val design: DesignDto? = null,
    val body: List<ListBodyDto>? = null
)