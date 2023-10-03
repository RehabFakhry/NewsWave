package com.the_chance.ui.ui.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.the_chance.ui.ui.theme.space16
import com.the_chance.ui.ui.theme.space8
import com.the_chance.ui.R
import com.the_chance.ui.ui.components.EmptySearchPlaceholder
import com.the_chance.ui.ui.components.EventHandler
import com.the_chance.ui.ui.components.Loading
import com.the_chance.ui.ui.features.search.components.CardSearch
import com.the_chance.ui.ui.features.search.components.SearchAppbar
import com.the_chance.ui.ui.features.search.components.SearchBar

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
//                SearchUiEffect.NavigateToNewsDetailsScreenEffect ->
//                    navController.navigateToNewsDetailsScreen(state.news)
                else -> {}
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

    EmptySearchPlaceholder(
        state = state.isConnectionError ,
        title = stringResource(R.string.there_is_no_connection),
        subtitle = stringResource(R.string.please_check_your_network_and_try_later),
        image = R.drawable.no_connection_placeholder
    )

    EmptySearchPlaceholder(
        state = !state.isLoading && state.news.isEmpty(),
        title = stringResource(R.string.there_is_no_result),
        subtitle = stringResource(R.string.please_try_again_with_another_words),
        image = R.drawable.no_result_placeholder,
    )

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
            columns = GridCells.Adaptive(minSize = 160.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(space16),
            horizontalArrangement = Arrangement.spacedBy(space8),
            verticalArrangement = Arrangement.spacedBy(space16),
        ) {
            item(span = { GridItemSpan(2) }) {
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