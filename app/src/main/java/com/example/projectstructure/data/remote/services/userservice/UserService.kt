package com.example.projectstructure.data.remote.services.userservice

import com.example.projectstructure.domain.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("/user")
    suspend fun getUser(
        @Query("key") userId: String
    ): User
}