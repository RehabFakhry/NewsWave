package com.the_chance.newswave.ui.features.discover

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.usecase.GetAllNewsByCategoryUseCase
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.newswave.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val getAllNewsByCategoryUseCase: GetAllNewsByCategoryUseCase
    )
    : BaseViewModel<DiscoverUiState, DiscoverUiEffect>(DiscoverUiState()),
    DiscoverInteractionListener {

    override val TAG: String = this::class.java.simpleName

    init {
        getNewsByCategory("general")
    }

    override fun getNewsByCategory(category: String) {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            { getAllNewsByCategoryUseCase(category) },
            ::onGetAllNewsByCategorySuccess,
            ::onGetAllNewsByCategoryError
        )
    }

    private fun onGetAllNewsByCategorySuccess(newsArticles: List<NewsArticle>) {
        if (!newsArticles.isNullOrEmpty()) {
            val news = newsArticles.filter { !newsArticles.isNullOrEmpty() }
            _state.update {
                it.copy(
                    isLoading = false,
                    news = news.map { newsArticle -> newsArticle.toNewUiState() }
                )
            }
        }
    }

    private fun onGetAllNewsByCategoryError(errorHandler: ErrorHandler) {
        _state.update { it.copy(isLoading = false, error = errorHandler) }
        if (errorHandler is ErrorHandler.NoConnection){
            _state.update { it.copy(isError = true) }
        }
    }

    fun updateChipSelected(chipSelected: ChipSelectedState) {
        _state.update { it.copy(chipSelected = chipSelected) }
    }

    override fun onClickSearchBar() {
        effectActionExecutor(_effect, DiscoverUiEffect.NavigateToSearchScreenEffect)
    }

    override fun onClickNewsItem() {
        TODO("Not yet implemented")
    }
}