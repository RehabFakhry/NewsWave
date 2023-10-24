package com.the_chance.ui.ui.features.discover

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.usecase.GetAllNewsByCategoryUseCase
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.ui.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val getAllNewsByCategoryUseCase: GetAllNewsByCategoryUseCase
) : BaseViewModel<DiscoverUiState, DiscoverUiEffect>(DiscoverUiState()),
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
        _state.update {
            it.copy(
                isLoading = false,
                error = errorHandler,
                isConnectionError = errorHandler is ErrorHandler.NoConnection
            )
        }
    }

    fun updateChipSelected(chipSelected: ChipSelectedState) {
        _state.update { it.copy(chipSelected = chipSelected) }
    }

    override fun onClickSearchBar() {
        effectActionExecutor(_effect, DiscoverUiEffect.ClickSearchIconEffect)
    }

    override fun onClickNewsItem(title: String) {
        effectActionExecutor(_effect, DiscoverUiEffect.ClickNewsItemEffect(title))
    }
}