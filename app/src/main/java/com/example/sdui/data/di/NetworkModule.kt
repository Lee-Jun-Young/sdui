package com.example.sdui.data.di

import com.example.sdui.RuntimeTypeAdapterFactory
import com.example.sdui.data.TestService
import com.example.sdui.data.dto.SectionAppBarDto
import com.example.sdui.data.dto.SectionBannerDto
import com.example.sdui.data.dto.SectionCardDto
import com.example.sdui.data.dto.SectionListDto
import com.example.sdui.data.dto.TypeDataDto
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideTextService(retrofit: Retrofit): TestService =
        retrofit.create(TestService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val typeAdapterFactory: TypeAdapterFactory =
            RuntimeTypeAdapterFactory.of(TypeDataDto::class.java, "viewType")
                .registerSubtype(SectionCardDto::class.java, "VIEW_TYPE_CARD")
                .registerSubtype(SectionBannerDto::class.java, "VIEW_TYPE_BANNER")
                .registerSubtype(SectionAppBarDto::class.java, "VIEW_TYPE_APP_BAR")
                .registerSubtype(SectionListDto::class.java, "VIEW_TYPE_LIST")

        return GsonBuilder().registerTypeAdapterFactory(
            typeAdapterFactory
        ).create()
    }

    companion object {
        private const val BASE_URL = "https://0b09d769-d2ea-47b2-bbcf-474f28f733d0.mock.pstmn.io/"
    }
}