package com.example.codingchallengebaudaprafa.domain.di

import com.example.codingchallengebaudaprafa.domain.LoginService
import com.example.codingchallengebaudaprafa.domain.LoginServiceImpl
import com.example.codingchallengebaudaprafa.domain.MockUserRepositoryImpl
import com.example.codingchallengebaudaprafa.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LoginDomainModule {

    @Binds
    fun LoginServiceImpl.bindLoginService(): LoginService

    @Binds
    fun MockUserRepositoryImpl.bindUserRepository(): UserRepository

}
