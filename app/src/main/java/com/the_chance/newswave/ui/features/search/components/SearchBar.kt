package com.the_chance.newswave.ui.features.search.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.NewsWaveTheme
import com.the_chance.newswave.ui.theme.Shapes
import com.the_chance.newswave.ui.theme.icon24
import com.the_chance.newswave.ui.theme.space1
import com.the_chance.newswave.ui.theme.space48
import com.the_chance.newswave.ui.theme.space56

@Composable
fun SearchBar(
    query: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        singleLine = true,
        modifier = modifier
            .height(space56)
            .fillMaxWidth()
            .border(
                width = space1,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                shape = Shapes.medium
            ),
        value = query,
        onValueChange = onValueChange,
        shape = Shapes.medium,
        textStyle = MaterialTheme.typography.displaySmall,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .size(icon24),
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
        },
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        },
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    NewsWaveTheme {
        SearchBar(
            query = "",
            onValueChange = {},
        )
    }
}