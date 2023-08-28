package com.example.codingchallengebaudaprafa.data.di

import com.example.codingchallengebaudaprafa.data.MockUserApi
import com.example.codingchallengebaudaprafa.data.UserApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LoginDataModule {
    @Binds
    fun MockUserApi.bindUserApi(): UserApi
}