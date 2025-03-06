package com.example.projectstructure.domain.model

import com.example.projectstructure.data.local.entity.UserEntity

data class User(
    val name: String
) {

    // can also make a mapper class and move it there
    fun toUserEntity(): UserEntity {
        return UserEntity(username = this.name)
    }
}
