package com.example.codingchallengebaudaprafa.poc

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.codingchallengebaudaprafa.pom.LoginModel


/**
 * @author Rafael Bonilla
 * Controller class that perform the assert validation on each automated test.
 */
class LoginController {

    private val loginModel = LoginModel()


    fun checkLoginSuccessful(composeTestRule: ComposeTestRule, email: String, password: String) {
        loginModel.apply {
            getEmailEditText(composeTestRule).apply {
                assertIsDisplayed()
                performTextInput(email)
            }

            getPasswordEditText(composeTestRule).apply {
                assertIsDisplayed()
                performTextInput(password)
            }

            getLoginButton(composeTestRule).apply {
                performClick()
            }

            getDialogText(composeTestRule).apply {
                assertTextContains(value = "Successful Login for: ", substring = true, ignoreCase = true)
            }
        }
    }

    fun checkLoginError(composeTestRule: ComposeTestRule, email: String, password: String) {
        loginModel.apply {
            getEmailEditText(composeTestRule).apply {
                assertIsDisplayed()
                performTextInput(email)
            }

            getPasswordEditText(composeTestRule).apply {
                assertIsDisplayed()
                performTextInput(password)
            }

            getLoginButton(composeTestRule).apply {
                performClick()
            }

            getDialogText(composeTestRule).apply {
                assertTextContains(value = "Verify your e-mail or password", substring = false, ignoreCase = true)
            }
        }
    }

    /**
     * Method to verify if Login Button enables after email and password is set.
     * @param email must have an email format (Patterns.EMAIL_ADDRESS.matcher)
     * @param password must be more than 3 letters.
     */
    fun checkEnableLoginButton(composeTestRule: ComposeTestRule, email: String, password: String) {
        loginModel.apply {
            getEmailEditText(composeTestRule).apply {
                assertIsDisplayed()
                performTextInput(email)
            }

            getPasswordEditText(composeTestRule).apply {
                assertIsDisplayed()
                performTextInput(password)
            }

            getLoginButton(composeTestRule).apply {
                assertIsEnabled()
            }
        }
    }

    /**
     * Method to verify if Login Button enables after email and password is set.
     * @param email must have an email format (Patterns.EMAIL_ADDRESS.matcher)
     * @param password must be more than 3 letters.
     */
    fun checkDisableLoginButton(composeTestRule: ComposeTestRule, email: String, password: String) {
        loginModel.apply {
            getEmailEditText(composeTestRule).apply {
                assertIsDisplayed()
                performTextInput(email)
            }

            getPasswordEditText(composeTestRule).apply {
                assertIsDisplayed()
                performTextInput(password)
            }

            getLoginButton(composeTestRule).apply {
                assertIsNotEnabled()
            }
        }
    }

    /**
     * Method to check that the dialog can be dismissed.
     */
    fun dismissDialog(composeTestRule: ComposeTestRule, email: String, password: String) {
        checkLoginSuccessful(composeTestRule, email, password)
        loginModel.getDialogButton(composeTestRule).apply {
            performClick()
            assertDoesNotExist()
        }
    }

}