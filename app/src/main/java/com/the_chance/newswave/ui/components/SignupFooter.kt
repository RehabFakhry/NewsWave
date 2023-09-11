package com.the_chance.newswave.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.Primary
import com.the_chance.newswave.ui.theme.black37
import com.the_chance.newswave.ui.theme.fontSize12
import com.the_chance.newswave.ui.theme.fontSize14
import com.the_chance.newswave.ui.theme.space32

@Composable
fun SignupFooter(
    modifier: Modifier = Modifier,
//    listener: SignupInteractionListener
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(bottom = space32)
    ) {
        Text(
            text = stringResource(R.string.already_have_account),
            style = MaterialTheme.typography.displaySmall.copy(black37),
            textAlign = TextAlign.Center,
            fontSize = fontSize12
        )
        TextButton(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(Color.Transparent)
        ) {
            Text(
                text = stringResource(R.string.log_in),
                style = MaterialTheme.typography.displayLarge.copy(Primary),
                textAlign = TextAlign.Center,
                fontSize = fontSize14
            )
        }
    }
}