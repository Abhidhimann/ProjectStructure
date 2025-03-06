package com.example.projectstructure.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("user_name")
    val name: String
)
