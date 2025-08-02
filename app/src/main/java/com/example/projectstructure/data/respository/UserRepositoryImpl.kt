package com.example.projectstructure.data.respository

import com.example.projectstructure.data.local.dao.UserDao
import com.example.projectstructure.data.remote.services.userservice.UserService
import com.example.projectstructure.domain.repository.UserRepository
import com.example.projectstructure.utils.ResultResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService,
) : UserRepository {

    // if you want can make a data source also but unnecessary for me

    override suspend fun doSomething(): ResultResponse<String> {
        return withContext(Dispatchers.IO) {
            try {
                val response = userService.getUser("")
                return@withContext ResultResponse.Success(response.toString())
            } catch (e: Exception) {
                // handing error
                return@withContext ResultResponse.Failed(Exception("do"))
            }
        }
    }
}