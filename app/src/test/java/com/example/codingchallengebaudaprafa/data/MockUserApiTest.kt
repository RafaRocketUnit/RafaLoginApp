package com.example.codingchallengebaudaprafa.data

import arrow.core.left
import arrow.core.right
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class MockUserApiTest {
    private val api:UserApi = MockUserApi()

    @Test
    fun `When login using correct credentials returns UserDto`() = runTest {
        val response = api.login("rafarocket@gmail.com", "1234")
        val expectedResponse = UserDto("rafa", "rafarocket@gmail.com", "1234").left()
        assertEquals(expectedResponse, response)
    }

    @Test
    fun `When login using incorrect credentials returns ApiError`() = runTest {
        val response = api.login("invalideUser@gmail.com", "1234")
        val expectedResponse = ApiError("Verify your e-mail or password").right()
        assertEquals(expectedResponse, response)
    }
}