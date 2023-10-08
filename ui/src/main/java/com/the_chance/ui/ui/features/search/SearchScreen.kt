package com.the_chance.ui.ui.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.the_chance.ui.ui.components.EmptySearchPlaceholder
import com.the_chance.ui.ui.components.EventHandler
import com.the_chance.ui.ui.components.Loading
import com.the_chance.ui.ui.features.search.components.CardSearch
import com.the_chance.ui.ui.features.search.components.SearchAppbar
import com.the_chance.ui.ui.features.search.components.SearchBar
import com.the_chance.ui.ui.theme.space16
import com.the_chance.ui.ui.theme.space8

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel()
){
    val state by searchViewModel.state.collectAsState()

    EventHandler(
        effects = searchViewModel.effect,
        handleEffect = { effect, navController ->
            when(effect) {
                SearchUiEffect.OnClickBackEffect -> navController.navigateUp()
                SearchUiEffect.OnClickNewsItemEffect -> TODO()
            }
        })

    SearchContent(
        state = state,
        onSearchTextChange = searchViewModel::onSearchTextChange,
        listener = searchViewModel
    )
}

@Composable
fun SearchContent(
    state: SearchUiState,
    onSearchTextChange: (String) -> Unit,
    listener: SearchInteractionListener
){
    EmptySearchPlaceholder(state = !state.isLoading && state.news.isEmpty())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(space16),
        verticalArrangement = Arrangement.spacedBy(space16)
    ) {

        SearchAppbar(onClickBack = listener::onClickBack)

        SearchBar(
            query = state.searchQuery,
            onValueChange = onSearchTextChange
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(space8),
            verticalArrangement = Arrangement.spacedBy(space16),
        ) {
            item {
                Loading( state.isLoading && state.news.isEmpty() )
            }
            items(state.news.size) { index ->
                val news = state.news[index]
                CardSearch(
                    imageUrl = news.image,
                    newsTitle = news.title,
                    author = news.author,
                    onClickCard = { listener.onClickNewsItem() }
                )
            }
        }
    }
}