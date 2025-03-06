package com.example.projectstructure.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.projectstructure.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(userEntity: UserEntity)
}