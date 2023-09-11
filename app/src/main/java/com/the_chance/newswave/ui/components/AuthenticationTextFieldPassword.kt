package com.the_chance.newswave.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.Shapes
import com.the_chance.newswave.ui.theme.black37
import com.the_chance.newswave.ui.theme.white200
import com.the_chance.newswave.ui.theme.error
import com.the_chance.newswave.ui.theme.heightOutlinedTextField
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space8
import com.the_chance.newswave.ui.theme.zero


@Composable
fun AuthenticationTextFieldPassword(
    hint: String,
    iconPainter: Painter,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    text: String = "",
    errorMessage: String = "",
    isError: Boolean = errorMessage.isNotEmpty(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Search
    )
) {

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    val icon =
        if (passwordVisible)
            painterResource(id = R.drawable.eye) else
            painterResource(id = R.drawable.eye_closed)
    Column {
        OutlinedTextField(

            modifier = modifier
                .fillMaxWidth()
                .padding(
                    end = space16,
                    start = space16,
                    bottom = space8
                )
                .height(heightOutlinedTextField),
            keyboardActions = KeyboardActions(),
            singleLine = true,
            value = text,
            onValueChange = onValueChange,
            visualTransformation = if (passwordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            label = {
                Text(
                    text = hint,
                    color = if (isError) error else black37,
                    style = MaterialTheme.typography.displaySmall,
                )
            },
            keyboardOptions = keyboardOptions,
            shape = Shapes.medium,
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedSupportingTextColor = if (isError) error else MaterialTheme.colorScheme.onTertiaryContainer,
                focusedContainerColor = (Color.Transparent),
                disabledContainerColor = (MaterialTheme.colorScheme.onTertiary),
                focusedBorderColor = if (isError) error else MaterialTheme.colorScheme.onTertiaryContainer,
                unfocusedBorderColor = if (isError) error else MaterialTheme.colorScheme.onTertiaryContainer,
            ),
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisible = !passwordVisible },
                    backgroundColor = Color.Transparent
                ) {
                    Icon(
                        painter = icon,
                        contentDescription = stringResource(R.string.icon_visible),
                        tint = if (isError) error else white200
                    )
                }
                if (isError) {
                    Icon(
                        painter = icon,
                        contentDescription = "",
                        tint = error
                    )
                }
            },
            leadingIcon = {
                Icon(
                    painter = iconPainter,
                    contentDescription = "",
                    tint = if (isError) error else white200
                )
            },
            isError = isError,
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = error,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(
                    start = space16,
                    top = zero
                )
            )
        }
    }
}