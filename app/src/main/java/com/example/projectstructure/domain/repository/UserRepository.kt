package com.example.projectstructure.domain.repository

import com.example.projectstructure.utils.ResultResponse

interface UserRepository {
    suspend fun doSomething(): ResultResponse<String>
}