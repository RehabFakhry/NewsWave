package com.the_chance.newswave.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.NewsWaveTheme
import com.the_chance.newswave.ui.theme.Primary
import com.the_chance.newswave.ui.theme.icon24
import com.the_chance.newswave.ui.theme.space2

@Composable
fun ItemLabel(
    label: String,
    onClickShowMore: () -> Unit,
    modifier: Modifier = Modifier,
    iconPainter: Painter = painterResource(id = R.drawable.icon_showmore),
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(R.string.show_more),
            modifier = Modifier.padding(bottom = space2).clickable{ onClickShowMore },
            color = Primary,
            style = MaterialTheme.typography.bodySmall,
        )

        IconButton(
            modifier = Modifier
                .size(icon24),
            onClick = onClickShowMore,
        ) {
            Icon(
                painter = iconPainter,
                contentDescription = null,
                tint = Primary,
            )
        }
    }
}

@Preview
@Composable
fun ItemLabelPreview() {
    NewsWaveTheme {
        ItemLabel(label = "Label", onClickShowMore = { /*TODO*/ })
    }
}