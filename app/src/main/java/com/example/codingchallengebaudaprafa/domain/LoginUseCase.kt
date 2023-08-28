package com.example.codingchallengebaudaprafa.domain

import javax.inject.Inject

/**
 * @author Rafael Bonilla
 * Login Use Case.
 */
class LoginUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}