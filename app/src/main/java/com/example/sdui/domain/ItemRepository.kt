package com.example.sdui.domain

import com.example.sdui.data.dto.ApiResult
import com.example.sdui.data.dto.ResponseDataDto
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    suspend fun getItemList(): Flow<ApiResult<ResponseDataDto>>
}