package com.example.codingchallengebaudaprafa.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.codingchallengebaudaprafa.data.MockUserApi
import com.example.codingchallengebaudaprafa.domain.LoginServiceImpl
import com.example.codingchallengebaudaprafa.domain.LoginUseCase
import com.example.codingchallengebaudaprafa.domain.MockUserRepositoryImpl

/**
 * @author Rafael Bonilla
 * Preview Parameter to display the viewmodel input in the composable.
 */
class PreviewParameterViewModel : PreviewParameterProvider<LoginViewModel> {
    private val loginApi = MockUserApi()
    private val loginService = LoginServiceImpl(loginApi)
    private val repository = MockUserRepositoryImpl(loginService)
    private val loginUseCase = LoginUseCase(repository)
    private val loginViewModel = LoginViewModel(loginUseCase)
    override val values: Sequence<LoginViewModel> = sequenceOf(loginViewModel)
}