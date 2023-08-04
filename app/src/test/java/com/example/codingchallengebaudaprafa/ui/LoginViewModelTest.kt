package com.example.codingchallengebaudaprafa.ui

import app.cash.turbine.test
import arrow.core.left
import arrow.core.right
import com.example.codingchallengebaudaprafa.domain.LoginUseCase
import com.example.codingchallengebaudaprafa.domain.User
import com.example.codingchallengebaudaprafa.data.ApiError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class LoginViewModelTest {

    private val loginUseCase: LoginUseCase = mockk(relaxed = true)
    private val viewModel = LoginViewModel(loginUseCase)

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `When login using correct credentials then ViewState LoginSuccess`() = runTest {
        coEvery { loginUseCase(any(), any()) } returns User("rafa", "l@l.com").left()
        val expectedValue = ViewState.LoginSuccessful(UserUi("rafa", "l@l.com"))
        viewModel.performLogin("l@l.com", "1234")
        coVerify { loginUseCase(any(), any()) }
        viewModel.getViewState().test {
            assertEquals(expectedValue, expectMostRecentItem())
        }
    }

    @Test
    fun `When login using incorrect credentials then ViewState Error`() = runTest {
        coEvery { loginUseCase(any(), any()) } returns ApiError("Error").right()
        val expectedValue = ViewState.Error("Error")
        viewModel.performLogin("rafa@rafa.conm", "1234")
        coVerify { loginUseCase(any(), any()) }
        viewModel.getViewState().test {
            assertEquals(expectedValue, expectMostRecentItem())
        }
    }
}