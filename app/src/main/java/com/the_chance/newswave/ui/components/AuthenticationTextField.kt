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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.Shapes
import com.the_chance.newswave.ui.theme.black37
import com.the_chance.newswave.ui.theme.dimens
import com.the_chance.newswave.ui.theme.error
import com.the_chance.newswave.ui.theme.white200

@Composable
fun AuthenticationTextField(
    hint: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    iconPainter: Painter? = null,
    text: String = "",
    errorMessage: String = "",
    oneLineOnly: Boolean = false,
    isPassword: VisualTransformation = VisualTransformation.None,
    isError: Boolean = errorMessage.isNotEmpty(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Search
    ),
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    Column {

        OutlinedTextField(
            singleLine = oneLineOnly,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    end = MaterialTheme.dimens.space16,
                    start = MaterialTheme.dimens.space16,
                    bottom = MaterialTheme.dimens.space8
                )
                .height(MaterialTheme.dimens.heightOutlinedTextField),
            value = text,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = hint,
                    color = if (isError) error else black37,
                    style = MaterialTheme.typography.displaySmall,
                )
            },
            visualTransformation = isPassword,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            shape = Shapes.medium,
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedSupportingTextColor = if (isError) error else MaterialTheme.colorScheme.onTertiaryContainer,
                focusedContainerColor = Color.Transparent,
                disabledContainerColor = (MaterialTheme.colorScheme.onTertiary),
                focusedBorderColor = if (isError) error else MaterialTheme.colorScheme.onTertiaryContainer,
                unfocusedBorderColor = if (isError) error else MaterialTheme.colorScheme.onTertiaryContainer,
            ),
            trailingIcon = {
                if (isError) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_error_password),
                        contentDescription = "",
                        tint = error
                    )
                }
            },
            leadingIcon = {
                if (iconPainter != null) {
                    Icon(
                        painter = iconPainter,
                        contentDescription = "",
                        tint = if (isError) error else white200
                    )
                }
            },
            isError = isError,
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = error,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(
                    start = MaterialTheme.dimens.space16,
                    top = MaterialTheme.dimens.zero
                )
            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TextFieldPreview() {
    AuthenticationTextField(
        hint = "Email",
        iconPainter = painterResource(id = R.drawable.ic_email),
        isError = true,
        errorMessage = stringResource(R.string.that_s_not_a_valid_email),
        onValueChange = {},
    )
}