package com.the_chance.ui.ui.features.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.the_chance.ui.ui.theme.NewsWaveTheme
import com.the_chance.ui.ui.theme.icon24
import com.the_chance.ui.ui.theme.space1
import com.the_chance.ui.ui.theme.space12
import com.the_chance.ui.ui.theme.space16
import com.the_chance.ui.ui.theme.space56
import com.the_chance.ui.ui.theme.space8
import com.the_chance.ui.R

@Composable
fun SearchBar(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .height(space56)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.tertiaryContainer,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(space1, MaterialTheme.colorScheme.onTertiaryContainer)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space8),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = space12, horizontal = space16)
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(icon24),
                tint = MaterialTheme.colorScheme.onBackground

            )
            Text(
                text = stringResource(R.string.search),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    NewsWaveTheme {
        SearchBar(
            icon = painterResource(id = R.drawable.icon_search),
            onClick = {}
        )
    }
}