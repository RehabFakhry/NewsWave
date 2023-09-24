package com.the_chance.newswave.ui.components.modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.ui.theme.icon24
import com.the_chance.newswave.ui.theme.icon32
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space32
import com.the_chance.newswave.ui.theme.space4


@Composable
fun NewsAppBar(
    startIcon: Int,
    title: String,
    endIcon: Int = 0,
    onStartIconClick: (() -> Unit)? = null,
    onEndIconClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = space32)
            .padding(horizontal = space16)
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = startIcon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(42.dp)
        )
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
        )

        if (endIcon != 0) {
            if (onEndIconClick != null) {
                IconButton(
                    modifier = Modifier
                        .size(icon32).padding(end = space4),
                    onClick = onEndIconClick
                ) {
                    Icon(
                        painter = painterResource(id = endIcon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.outlineVariant,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}