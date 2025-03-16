package com.example.projectstructure.domain.usercases

import com.example.projectstructure.domain.repository.UserRepository
import com.example.projectstructure.utils.ResultResponse
import javax.inject.Inject

class GetUserUserCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun execute(): ResultResponse<String> {
        return userRepository.doSomething()
    }
}