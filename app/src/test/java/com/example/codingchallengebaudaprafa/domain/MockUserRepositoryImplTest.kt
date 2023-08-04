package com.example.codingchallengebaudaprafa.domain

import arrow.core.left
import arrow.core.right
import com.example.codingchallengebaudaprafa.data.ApiError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class MockUserRepositoryImplTest {

    private val loginService: LoginService = mockk(relaxed = true)
    private val mockUserRepositoryImpl = MockUserRepositoryImpl(loginService)

    @Test
    fun `When login service is correct then return an User`() = runTest {
        coEvery {
            loginService.login(any(), any())
        } returns User("name", "r@r.com").left()

        val expectedValue = User("name", "r@r.com").left()
        val login = mockUserRepositoryImpl.login("r@r.com", "1234")
        coVerify { loginService.login(any(), any())  }

        assertEquals(expectedValue, login)
    }

    @Test
    fun `When login service is incorrect then return an Error`() = runTest {
        coEvery {
            loginService.login(any(), any())
        } returns ApiError("error").right()

        val expectedValue = ApiError("error", ).right()
        val login = mockUserRepositoryImpl.login("r@r.com", "1234")
        coVerify { loginService.login(any(), any())  }

        assertEquals(expectedValue, login)
    }

}