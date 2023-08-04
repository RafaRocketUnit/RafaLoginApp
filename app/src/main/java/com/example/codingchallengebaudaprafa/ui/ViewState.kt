package com.example.codingchallengebaudaprafa.ui

/**
 * @author Rafael Bonilla
 * View State of the login response to manage.
 */
sealed class ViewState {
    data class LoginSuccessful(val userUi: UserUi): ViewState()
    object Idle: ViewState()
    data class Error(val error: String): ViewState()
}