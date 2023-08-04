package com.example.codingchallengebaudaprafa.domain

import arrow.core.Either
import com.example.codingchallengebaudaprafa.data.ApiError

/**
 * @author Rafael Bonilla
 * Interface that consume the login service.
 */
interface LoginService {
    suspend fun login(email: String, password: String): Either<User, ApiError>
}