package com.example.instadev.data.repository

import com.example.instadev.data.datasource.api.ApiServices
import com.example.instadev.data.response.UserResponse
import com.example.instadev.data.response.toDomain
import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.entity.UserMode
import com.example.instadev.domain.repository.AuthRepository
import javax.sql.DataSource

class AuthRepositoryImpl(val api: ApiServices): AuthRepository {

    override suspend fun doLogin(user: String, password: String): UserEntity {
        val response = api.doLogin()
//        return userResponse.toDomain();
    }
}