package com.example.codingchallengebaudaprafa.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codingchallengebaudaprafa.R
import com.example.codingchallengebaudaprafa.isValidEmail

/**
 * @author Rafael Bonilla
 * Login UI composable
 */
@Preview
@Composable
fun LoginScreen(
    @PreviewParameter(PreviewParameterViewModel::class) loginViewModel: LoginViewModel
) {

    val stateComposable = remember {
        mutableStateOf<ViewState>(ViewState.Idle)
    }

    LaunchedEffect(Unit) {
        loginViewModel.getViewState().collect {
            stateComposable.value = it
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            painter = painterResource(id = R.drawable.logo_baubap),
            contentDescription = "Baubap",
            contentScale = ContentScale.FillWidth,
        )

        Spacer(Modifier.size(10.dp))

        Text(
            text = "Login",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.size(10.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .testTag("email"),
            value = email.value,
            placeholder = {
                Text("E-mail")
            },
            onValueChange = {
                email.value = it
            }
        )

        Spacer(Modifier.size(10.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .testTag("password"),
            value = password.value,
            placeholder = {
                Text("Password")
            },
            onValueChange = {
                password.value = it
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(Modifier.size(10.dp))

        Button(
            onClick = {
                loginViewModel.performLogin(email.value, password.value)
            }, Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .testTag("loginButton"),
            enabled = email.value.isValidEmail() && password.value.length > 3
        ) {
            Text(text = "Login")
        }

        HandleDialog(stateComposable.value) {
            loginViewModel.resetState()
        }
    }
}

@Composable
fun HandleDialog(state: ViewState, onDismiss: () -> Unit) {
    when (state) {
        is ViewState.LoginSuccessful -> CustomDialog(
            "Successful Login for: " + state.userUi.name,
            onDismiss
        )

        is ViewState.Error -> CustomDialog(state.error, onDismiss)
        is ViewState.Idle -> Unit
    }
}

@Composable
fun CustomDialog(message: String, onDismiss: () -> Unit) {
    AlertDialog(
        shape = RoundedCornerShape(20.dp),
        onDismissRequest = { onDismiss() },
        text = {
            Text(modifier = Modifier.testTag("dialogText"),text = message)
        },
        confirmButton = {
            TextButton(
                modifier = Modifier.testTag("dialogButton"),
                onClick = { onDismiss() }
            ) {
                Text("Cancel")
            }
        },
    )
}