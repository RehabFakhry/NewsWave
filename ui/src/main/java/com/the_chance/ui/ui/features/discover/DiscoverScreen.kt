package com.the_chance.ui.ui.features.discover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.the_chance.ui.R
import com.the_chance.ui.ui.components.BreakingNewsForDiscover
import com.the_chance.ui.ui.components.ConnectionErrorPlaceholder
import com.the_chance.ui.ui.components.ContentVisibility
import com.the_chance.ui.ui.components.EventHandler
import com.the_chance.ui.ui.components.Loading
import com.the_chance.ui.ui.features.discover.components.CustomChip
import com.the_chance.ui.ui.features.discover.components.DiscoverAppBar
import com.the_chance.ui.ui.features.home.component.SearchBar
import com.the_chance.ui.ui.features.news_details.navigateToNewsDetailsScreen
import com.the_chance.ui.ui.features.search.navigateToSearchScreen
import com.the_chance.ui.ui.theme.space16
import com.the_chance.ui.ui.theme.space24
import com.the_chance.ui.ui.theme.space8

@Composable
fun DiscoverScreen(
    discoverViewModel: DiscoverViewModel = hiltViewModel()
) {
    val state by discoverViewModel.state.collectAsState()

    EventHandler(
        effects = discoverViewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                is DiscoverUiEffect.ClickSearchIconEffect ->
                    navController.navigateToSearchScreen()
                is DiscoverUiEffect.ClickNewsItemEffect ->
                    navController.navigateToNewsDetailsScreen(effect.title)
            }
        })

    Loading(state = state.isLoading && state.news.isEmpty())
    ConnectionErrorPlaceholder(state = state.isConnectionError)

    ContentVisibility(state = state.showDiscover()) {
        DiscoverContent(state = state, listener = discoverViewModel, viewModel = discoverViewModel)
    }
}

@Composable
fun DiscoverContent(
    state: DiscoverUiState,
    listener: DiscoverInteractionListener,
    modifier: Modifier = Modifier,
    viewModel: DiscoverViewModel,
    ) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        DiscoverAppBar(
            modifier = modifier.padding(
                top = space24, start = space16, end = space16, bottom = space8)
        )

        SearchBar(
            icon = painterResource(id = R.drawable.icon_search),
            onClick = listener::onClickSearchBar,
            modifier = modifier.padding(horizontal = space16, vertical = space8)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(space8),
            contentPadding = PaddingValues(space16)
        ) {

            item {
                CustomChip(
                    isSelected = state.general(),
                    text = stringResource(R.string.general),
                    width = 100.dp,
                    onClick = { listener.getNewsByCategory("general") },
                )
            }

            item {
                CustomChip(
                    isSelected = state.business(),
                    text = stringResource(R.string.business),
                    width = 100.dp,
                    onClick = {
                        listener.getNewsByCategory("business")
                        viewModel.updateChipSelected(ChipSelectedState.BUSINESS)
                    },
                )
            }

            item {
                CustomChip(
                    isSelected = state.entertainment(),
                    text = stringResource(R.string.entertainment),
                    width = 100.dp,
                    onClick = {
                        listener.getNewsByCategory("entertainment")
                        viewModel.updateChipSelected(ChipSelectedState.ENTERTAINMENT)
                    },
                )
            }

            item {
                CustomChip(
                    isSelected = state.health(),
                    text = stringResource(R.string.health),
                    width = 100.dp,
                    onClick = {
                        listener.getNewsByCategory("health")
                        viewModel.updateChipSelected(ChipSelectedState.HEALTH)
                    },
                )
            }

            item {
                CustomChip(
                    isSelected = state.science(),
                    text = stringResource(R.string.science),
                    width = 100.dp,
                    onClick = {
                        listener.getNewsByCategory("science")
                        viewModel.updateChipSelected(ChipSelectedState.SCIENCE)
                    },
                )
            }

            item {
                CustomChip(
                    isSelected = state.sports(),
                    text = stringResource(R.string.sports),
                    width = 100.dp,
                    onClick = {
                        listener.getNewsByCategory("sports")
                        viewModel.updateChipSelected(ChipSelectedState.SPORTS)
                    },
                )
            }

            item {
                CustomChip(
                    isSelected = state.technology(),
                    width = 100.dp,
                    text = stringResource(R.string.technology),
                    onClick = {
                        listener.getNewsByCategory("technology")
                        viewModel.updateChipSelected(ChipSelectedState.TECHNOLOGY)
                    },
                )
            }
        }

        BreakingNewsForDiscover(
            modifier = modifier.padding(space16),
            news = state.nonDeprecatedNews,
            title = state.newsItem.title,
            onClickBreakingNewsCard = { listener.onClickNewsItem(state.newsItem.title) },
        )
    }
}