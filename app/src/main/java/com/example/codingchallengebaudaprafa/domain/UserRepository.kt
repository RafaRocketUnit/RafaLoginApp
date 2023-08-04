package com.example.codingchallengebaudaprafa.domain

import arrow.core.Either
import com.example.codingchallengebaudaprafa.data.ApiError


/**
 * @author Rafael Bonilla
 * User Repository
 */
interface UserRepository {
    suspend fun login(email: String, password: String): Either<User, ApiError>
}