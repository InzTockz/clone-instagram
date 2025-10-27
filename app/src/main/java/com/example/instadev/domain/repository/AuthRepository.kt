package com.example.instadev.domain.repository

import com.example.instadev.data.response.UserResponse
import com.example.instadev.data.response.toDomain
import com.example.instadev.domain.entity.UserEntity

interface AuthRepository {
    suspend fun doLogin(user:String, password:String): UserEntity
//    {
//        val userResponse: UserResponse = UserResponse("","", "", 10, listOf())
//
//        return userResponse.toDomain()
//    }
}