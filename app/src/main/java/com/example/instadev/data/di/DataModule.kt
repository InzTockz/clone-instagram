package com.example.instadev.data.di

import com.example.instadev.data.datasource.api.ApiServices
import com.example.instadev.data.repository.AuthRepositoryImpl
import com.example.instadev.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideAuthRepository(api: ApiServices): AuthRepository{
        return AuthRepositoryImpl(api)
    }

    @Provides
    fun provideApiServices(retrofit: Retrofit): ApiServices{
        return retrofit.create(ApiServices::class.java)
    }

    @Provides
    fun provideRetrofit(json: Json): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://fredydev-bdbab-default-rtdb.firebaseio.com/")
            .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }

    @Provides
    fun provideJson(): Json{
        return Json {
            ignoreUnknownKeys =true
            isLenient = true

        }
    }
}