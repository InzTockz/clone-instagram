package com.example.instadev.domain.repository

import com.example.instadev.data.response.UserResponse
import com.example.instadev.data.response.toDomain
import com.example.instadev.domain.entity.UserEntity

interface AuthRepository {
    fun doLogin(user:String, password:String): UserEntity
}