package com.example.codingchallengebaudaprafa.domain

/**
 * @author Rafael Bonilla
 * Login Use Case.
 */
class LoginUseCase(private val repository: UserRepository = MockUserRepositoryImpl()) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}