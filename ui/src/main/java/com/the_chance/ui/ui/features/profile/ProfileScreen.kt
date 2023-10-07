package com.the_chance.ui.ui.features.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.the_chance.ui.ui.theme.space16

@Composable
fun ProfileScreen(

){
    ProfileContent()
}

@Composable
fun ProfileContent(){

    Column(modifier = Modifier.padding(space16),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Profile Screen is inProgress")
    }
}