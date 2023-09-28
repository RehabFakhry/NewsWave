package com.the_chance.newswave.ui.features.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.space2
import com.the_chance.newswave.ui.theme.space24
import com.the_chance.newswave.ui.theme.space8

@Composable
fun SearchAppbar(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
){
    Row(
        modifier = modifier.fillMaxWidth().padding(top = space24),
        horizontalArrangement = Arrangement.spacedBy(space8),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onClickBack,
        ) {
            Icon(
                modifier = modifier.padding(top = space2),
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "icon back",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Text(
            text = stringResource(id = R.string.search),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
