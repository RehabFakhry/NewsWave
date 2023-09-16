package com.the_chance.newswave.ui.features.login

import android.widget.Toast
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.AuthenticationTextField
import com.the_chance.newswave.ui.components.AuthenticationTextFieldPassword
import com.the_chance.newswave.ui.components.FilledButton
import com.the_chance.newswave.ui.components.SignupFooter
import com.the_chance.newswave.ui.components.Text
import com.the_chance.newswave.ui.features.signup.SignupScreen
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space8
import kotlinx.coroutines.launch
import kotlin.math.sign

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel()
){
    val state by loginViewModel.loginState.collectAsState(initial = null)
//    LoginContent(state = state, loginViewModel::loginUser)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginContent(
    state: LoginUiState?,
    onClickLogin: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

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
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            )
        )

        AuthenticationTextFieldPassword(
            text = "password",
            hint = stringResource(R.string.password),
            iconPainter = painterResource(id = R.drawable.ic_password),
            onValueChange = { password = it},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
        )

        FilledButton(
            label = stringResource(id = R.string.log_in),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = space8),
            onClick = { onClickLogin },
            isLoading = false
        )

        if( state?.loading == true)
            CircularProgressIndicator()

        SignupFooter(
            stringResource(R.string.you_don_t_have_account),
            stringResource(id = R.string.sign_up), modifier.padding(top = space8)
        )
    }

    LaunchedEffect(key1 = state?.isSuccess){
        scope.launch {
            if (state?.isSuccess?.isNotEmpty() == true){
                val success = state.isSuccess
                Toast.makeText(context, "$success", Toast.LENGTH_LONG)
            }
        }
    }

    LaunchedEffect(key1 = state?.isError){
        scope.launch {
            if (state?.isError?.isNotEmpty() == true){
                val error = state.isError
                Toast.makeText(context, "$error", Toast.LENGTH_LONG)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}