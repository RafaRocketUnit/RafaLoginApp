package com.example.codingchallengebaudaprafa.data

import arrow.core.Either

/**
 * @author Rafael Bonilla
 * Interface of the login perform endpoint emulation.
 */
interface UserApi {
    suspend fun login(email: String, password: String): Either<UserDto, ApiError>
}