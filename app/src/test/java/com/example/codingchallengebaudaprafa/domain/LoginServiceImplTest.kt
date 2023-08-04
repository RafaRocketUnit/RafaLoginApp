package com.example.codingchallengebaudaprafa.domain

import arrow.core.left
import arrow.core.right
import com.example.codingchallengebaudaprafa.data.UserApi
import com.example.codingchallengebaudaprafa.data.UserDto
import com.example.codingchallengebaudaprafa.data.ApiError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class LoginServiceImplTest {

    private val userApi: UserApi = mockk(relaxed = true)
    private val loginServiceImpl = LoginServiceImpl(userApi)

    @Test
    fun  `When login service is correct then return an User`() = runTest {
        coEvery {
            userApi.login(any(), any())
        } returns UserDto( "rafa","rafarocket@gmail.com", "1234").left()

        val expectedValue = User("rafa", "rafarocket@gmail.com").left()
        val login = loginServiceImpl.login("rafarocket@gmail.com", "1234")
        coVerify { userApi.login(any(), any()) }

        assertEquals(expectedValue, login)
    }

    @Test
    fun  `When login service is incorrect then return an Error`() = runTest {
        coEvery { userApi.login(any(), any()) } returns ApiError( "error").right()
        val expectedValue = ApiError( "error").right()
        val login = loginServiceImpl.login("rafarocket@gmail.com", "1234")
        coVerify { userApi.login(any(), any()) }

        assertEquals(expectedValue, login)
    }

}