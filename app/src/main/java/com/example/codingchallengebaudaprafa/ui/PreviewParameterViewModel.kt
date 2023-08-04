package com.example.codingchallengebaudaprafa.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

/**
 * @author Rafael Bonilla
 * Preview Parameter to display the viewmodel input in the composable.
 */
class PreviewParameterViewModel : PreviewParameterProvider<LoginViewModel> {
    override val values: Sequence<LoginViewModel> = sequenceOf(LoginViewModel())
}