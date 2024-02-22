package com.example.sdui.data.datasource

import com.example.sdui.data.TestService
import com.example.sdui.data.dto.ApiResult
import com.example.sdui.data.dto.ResponseDataDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

interface ItemDataSource {
    suspend fun getItemList(): Flow<ApiResult<ResponseDataDto>>
}

class ItemDataSourceImpl @Inject constructor(private val service: TestService) :
    ItemDataSource {
    override suspend fun getItemList(): Flow<ApiResult<ResponseDataDto>> = flow {
        runCatching { service.getItemList() }
            .onSuccess {
                emit(ApiResult.Success(it))
            }
            .onFailure {
                emit(ApiResult.Error(errorMsg = it.message))
            }
    }
}