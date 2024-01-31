package com.example.sdui.data

import com.example.sdui.data.dto.ResponseDataDto
import com.example.sdui.data.dto.TypeDataDto
import retrofit2.Response
import retrofit2.http.GET

interface TestService {

    @GET("list")
    suspend fun getItemList(): Response<ResponseDataDto>
}