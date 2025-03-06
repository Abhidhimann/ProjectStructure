package com.example.projectstructure.di

import com.example.projectstructure.data.remote.services.userservice.UserService
import com.example.projectstructure.utils.Api
import com.example.projectstructure.utils.RetroFitClientHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Headers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Provides
    @Singleton
    fun providesUserService(): UserService {
        return RetroFitClientHelper().getApiClient(
            Api.BASE_URL.getValue()
        ).create(UserService::class.java)
    }


}