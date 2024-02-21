package com.example.sdui.data.datasource

import com.example.sdui.data.TestService
import com.example.sdui.data.dto.ResponseDataDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

interface ItemDataSource {
    suspend fun getItemList(): Flow<ResponseDataDto>
}

class ItemDataSourceImpl @Inject constructor(private val service: TestService) :
    ItemDataSource {
    override suspend fun getItemList(): Flow<ResponseDataDto> = flow {
        runCatching { service.getItemList() }
            .onSuccess { emit(it.body()!!) }
            .onFailure {
                Timber.e(it)
            }
    }
}