package com.example.codingchallengebaudaprafa.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengebaudaprafa.domain.LoginUseCase
import com.example.codingchallengebaudaprafa.toUserUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Rafael Bonilla
 * Login ViewModel to handle response.
 */
@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {

    private val viewState = MutableStateFlow<ViewState>(ViewState.Idle)

    /**
     * Method to collect the login response.
     *
     * @param email email to login
     * @param password password to login
     */
    fun performLogin(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(email, password)
                .fold({
                    viewState.value = ViewState.LoginSuccessful(it.toUserUi())
                }, {
                    viewState.value = ViewState.Error(it.error)
                })
        }
    }

    /**
     * Method to get the view state response of the login.
     * @return viewState
     */
    fun getViewState(): Flow<ViewState> = viewState


    /**
     * Method to reset the view state to idle state, after a login call.
     */
    fun resetState() {
        viewState.value = ViewState.Idle
    }
}