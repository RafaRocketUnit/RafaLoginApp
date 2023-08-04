package com.example.codingchallengebaudaprafa.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ActivityScenario
import com.example.codingchallengebaudaprafa.poc.LoginController
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author Rafael Bonilla
 * Automation test of the Login UI
 */
class LoginUiTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val controller = LoginController()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun performLoginSuccessful() {
        controller.checkLoginSuccessful(composeTestRule, "rafarocket@gmail.com", "1234")
    }

    @Test
    fun performLoginError() {
        controller.checkLoginError(composeTestRule, "rafarocket@gmail.com", "1236")
    }

    @Test
    fun checkEnableLoginButton() {
        controller.checkEnableLoginButton(composeTestRule, "rafarocket@gmail.com", "1234")
    }

    @Test
    fun checkDisableLoginButtonByEmailIncomplete() {
        controller.checkDisableLoginButton(composeTestRule, "rafarocket@gmail.", "1234")
    }

    @Test
    fun checkDisableLoginButtonByPasswordIncomplete() {
        controller.checkDisableLoginButton(composeTestRule, "rafarocket@gmail.com", "123")
    }

    @Test
    fun checkDismissDialog() {
        controller.dismissDialog(composeTestRule, "rafarocket@gmail.com", "1234")
    }
}