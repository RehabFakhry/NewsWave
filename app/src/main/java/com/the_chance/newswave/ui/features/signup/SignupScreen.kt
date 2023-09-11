package com.the_chance.newswave.ui.features.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.AuthenticationTextField
import com.the_chance.newswave.ui.components.AuthenticationTextFieldPassword
import com.the_chance.newswave.ui.components.FilledButton
import com.the_chance.newswave.ui.components.SignupFooter
import com.the_chance.newswave.ui.components.Text
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space8

@Composable
fun SignupScreen() {
    SignupContent()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignupContent(
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(align = Alignment.TopEnd)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_autho),
            contentDescription = "Auth Image",
            modifier = modifier
                .fillMaxWidth()
                .size(350.dp)
                .offset(x = 70.dp, y = (-65).dp)
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 215.dp)
            .padding(horizontal = space16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space8)
    ) {

        Text(
            text = stringResource(R.string.sign_up),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineLarge,
        )

        Text(
            text = stringResource(R.string.be_part_of_our_news_community_sign_up_to_get_started),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.headlineMedium,
        )

        AuthenticationTextField(
            oneLineOnly = true,
            text = "",
            hint = stringResource(R.string.full_name),
            iconPainter = painterResource(id = R.drawable.ic_person),
            onValueChange = {},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            )
            //                errorMessage = "error message",
        )

        AuthenticationTextField(
            oneLineOnly = true,
            text = "",
            hint = stringResource(R.string.email),
            iconPainter = painterResource(id = R.drawable.ic_email),
            onValueChange = { },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            )
            //                errorMessage = "state.emailState.errorState",
        )

        AuthenticationTextFieldPassword(
            text = "",
            hint = stringResource(R.string.password),
            iconPainter = painterResource(id = R.drawable.ic_password),
            onValueChange = { },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
//                errorMessage = "state.passwordState.errorState",
        )

        AuthenticationTextFieldPassword(
            text = "",
            hint = stringResource(R.string.confirm_password),
            iconPainter = painterResource(id = R.drawable.ic_password),
            onValueChange = {},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() })
            //                errorMessage = "state.confirmPasswordState.errorState",
        )

        FilledButton(
            label = "Sign up",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = space8),
            onClick = { },
            isLoading = false
        )
        SignupFooter()
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSignUpScreen() {
    SignupScreen()
}