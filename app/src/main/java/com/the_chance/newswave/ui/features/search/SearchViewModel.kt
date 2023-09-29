package com.the_chance.newswave.ui.features.search

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.usecase.SearchForNewsArticleUseCase
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.newswave.ui.base.BaseViewModel
import com.the_chance.newswave.ui.features.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchForNewsArticleUseCase: SearchForNewsArticleUseCase
) : BaseViewModel<SearchUiState, SearchUiEffect>(SearchUiState()),
    SearchInteractionListener {

    private val actionStream = MutableSharedFlow<String>()
    override val TAG: String = this::class.java.simpleName

    init {
        observeSearchQuery()
    }

    override fun getNewsBySearch() {
        _state.update { it.copy(isLoading = true, isError = false) }
        val value = state.value
        tryToExecute(
            { searchForNewsArticleUseCase(value.searchQuery) },
            ::onGetSearchForNewsSuccess,
            ::onGetSearchForNewsError
        )
    }

    private fun onGetSearchForNewsSuccess(newsArticles: List<NewsArticle>) {
        _state.update {
            it.copy(
                isLoading = false,
                news = newsArticles.map { news -> news.toNewsUiState() }
            )
        }
    }

    private fun onGetSearchForNewsError(errorHandler: ErrorHandler) {
        _state.update { it.copy(isLoading = false, error = errorHandler) }
        if (errorHandler is ErrorHandler.NoConnection)
            _state.update { it.copy(isError = true) }
    }

    fun onSearchTextChange(query: String){
        _state.update { it.copy(searchQuery = query) }
        viewModelScope.launch { actionStream.emit(query) }
    }

    private fun observeSearchQuery(){
        viewModelScope.launch (Dispatchers.Unconfined){
            actionStream.debounce(700).distinctUntilChanged().filter {
                query -> query.isNotBlank()
            }.collect {
                resetSearchResult()
                getNewsBySearch()
            }
        }
    }

    private fun resetSearchResult() {
        _state.update { it.copy(news = listOf()) }
    }

    override fun onClickNewsItem() {
        TODO("Not yet implemented")
    }

    override fun onClickBack() {
        effectActionExecutor(_effect, SearchUiEffect.OnClickBackEffect)
    }
}