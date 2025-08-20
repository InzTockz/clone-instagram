package com.example.instadev.data.repository

import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.repository.AuthRepository
import javax.sql.DataSource

class AuthRepositoryImpl(): AuthRepository {

    override fun doLogin(user: String, password: String): UserEntity {
        TODO("Not yet implemented")
    }
}