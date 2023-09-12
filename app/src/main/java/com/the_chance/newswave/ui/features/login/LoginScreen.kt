package com.the_chance.newswave.ui.features.login

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
import com.the_chance.newswave.ui.features.signup.SignupScreen
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space8
import kotlin.math.sign

@Composable
fun LoginScreen(){
    LoginContent()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginContent(
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
                .size(360.dp)
                .offset(x = 60.dp)
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 325.dp)
            .padding(horizontal = space16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space16)
    ) {

        Text(
            text = stringResource(R.string.welcome_back),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineLarge,
        )

        Text(
            text = stringResource(R.string.stay_ahead_of_the_news_curve_log_in_to_your_account_now),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.headlineMedium,
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

        FilledButton(
            label = stringResource(id = R.string.log_in),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = space8),
            onClick = { },
            isLoading = false
        )
        SignupFooter(
            stringResource(R.string.you_don_t_have_account),
            stringResource(id = R.string.sign_up), modifier.padding(top = space8)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}