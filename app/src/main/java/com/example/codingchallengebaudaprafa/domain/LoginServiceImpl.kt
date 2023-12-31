package com.example.codingchallengebaudaprafa.domain

import arrow.core.Either
import com.example.codingchallengebaudaprafa.data.UserApi
import com.example.codingchallengebaudaprafa.data.ApiError
import com.example.codingchallengebaudaprafa.toUser
import javax.inject.Inject

/**
 * @author Rafael Bonilla
 * Implementation class of login service interface.
 */
class LoginServiceImpl @Inject constructor(private val userApi: UserApi): LoginService {

    /**
     * Login call from endpoint (userApi)
     * @param email email to login
     * @param password password to authenticated
     * @return Either object with response. (User or ApiError)
     */
    override suspend fun login(email: String, password: String): Either<User, ApiError> {
        return userApi.login(email, password).mapLeft { it.toUser() }
    }
}