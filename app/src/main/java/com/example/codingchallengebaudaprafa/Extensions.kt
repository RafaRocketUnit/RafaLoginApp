package com.example.codingchallengebaudaprafa

import android.text.TextUtils
import android.util.Patterns
import com.example.codingchallengebaudaprafa.data.UserDto
import com.example.codingchallengebaudaprafa.domain.User
import com.example.codingchallengebaudaprafa.ui.UserUi

/**
 * Check if the string is an email format.
 */
fun String.isValidEmail(): Boolean =
    if (TextUtils.isEmpty(this)) {
        false
    } else {
        Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

/**
 * Transformation from UserDto(data layer) to User(domain layer)
 */
fun UserDto.toUser(): User = User(name, email)

/**
 * Transformation from User(domain layer) to UserUi(UI layer)
 */
fun User.toUserUi() = UserUi(name, email)