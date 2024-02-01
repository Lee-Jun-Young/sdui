package com.example.sdui.domain

import com.example.sdui.data.dto.ResponseDataDto

interface ItemRepository {

    suspend fun getItemList(): ResponseDataDto
}