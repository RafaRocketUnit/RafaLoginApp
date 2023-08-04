package com.example.codingchallengebaudaprafa.domain

import arrow.core.Either
import com.example.codingchallengebaudaprafa.data.ApiError


/**
 * @author Rafael Bonilla
 * Implementation class of the User Repository, define by the Use Case.
 */
class MockUserRepositoryImpl(private val loginService: LoginService = LoginServiceImpl()): UserRepository {

    /**
     * Login call on LoginService
     * @param email
     * @param password
     * @return Either object (User or ApiError)
     */
    override suspend fun login(email: String, password: String): Either<User, ApiError> {
        return loginService.login(email, password)
    }
}