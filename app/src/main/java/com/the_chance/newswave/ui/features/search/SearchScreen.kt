package com.the_chance.newswave.ui.features.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.the_chance.newswave.ui.theme.space16

@Composable
fun SearchScreen(

){
    SearchContent()
}

@Composable
fun SearchContent(

){

    Column(modifier = Modifier.padding(space16)) {
        Text(text = "Hello Discover Screen")
    }
}