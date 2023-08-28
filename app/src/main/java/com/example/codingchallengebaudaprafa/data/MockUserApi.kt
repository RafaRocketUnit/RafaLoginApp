package com.example.codingchallengebaudaprafa.data

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import javax.inject.Inject

/**
 * @author Rafael Bonilla
 * MockUserApi class to set some Users to login successful, otherwise to return the login error.
 */
class MockUserApi @Inject constructor(): UserApi {

    private val availableUsers = listOf<UserDto>(
        UserDto("rafa", "rafarocket@gmail.com", "1234"),
        UserDto("david", "david@x.com", "1234"),
        UserDto("ana", "ana@y.com", "1234")
    )

    /**
     * Login Mock emulation of endpoint call.
     * @param email email to login.
     * @param password password to authenticate
     * @return Either object with response. (User or ApiError)
     */
    override suspend fun login(email: String, password: String): Either<UserDto, ApiError> {
        val user = availableUsers.firstOrNull { it.email == email && it.password == password }
        return user?.left() ?: ApiError("Verify your e-mail or password").right()
    }
}