package com.example.codingchallengebaudaprafa.pom

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag


/**
 * @author Rafael Bonilla
 * Login Model that retrieve the composable ui items to be use on the automation test.
 */
class LoginModel {

    fun getEmailEditText(composeTestRule: ComposeTestRule) =
        composeTestRule.onNodeWithTag("email", useUnmergedTree = true)

    fun getPasswordEditText(composeTestRule: ComposeTestRule) =
        composeTestRule.onNodeWithTag("password", useUnmergedTree = true)

    fun getLoginButton(composeTestRule: ComposeTestRule) =
        composeTestRule.onNodeWithTag("loginButton", useUnmergedTree = true)

    fun getDialogButton(composeTestRule: ComposeTestRule) =
        composeTestRule.onNodeWithTag("dialogButton", useUnmergedTree = true)

    fun getDialogText(composeTestRule: ComposeTestRule) =
        composeTestRule.onNodeWithTag("dialogText", useUnmergedTree = true)
}