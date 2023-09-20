package com.the_chance.newswave.ui.features.home

import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.usecase.GetAllNewsUseCase
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.newswave.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllNewsUseCase: GetAllNewsUseCase,
) : BaseViewModel<NewsArticleUiState, HomeUiEffect>(NewsArticleUiState()),
HomeInteractionListener {
    override val TAG: String = this::class.java.simpleName

    init {
        getAllNewsArticle()
    }

    override fun getAllNewsArticle() {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            { getAllNewsUseCase() },
            ::onGetAllNewsSuccess,
            ::onGetAllNewsError
        )
    }

    private fun onGetAllNewsSuccess(news: List<NewsArticle>?) {
        if (!news.isNullOrEmpty()) {
            _state.update {
                it.copy(
                    isLoading = false,
                    news = news.map { newsArticle -> newsArticle.toNewsUiState() }
                )
            }
        }
        }

    private fun onGetAllNewsError(error: ErrorHandler) {
        _state.update { it.copy(isLoading = false, error = error) }
        if (error is ErrorHandler.NoConnection) {
            _state.update { it.copy(isError = true) }
        }
    }
}