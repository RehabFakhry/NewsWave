package com.the_chance.newswave.ui.features.home

import android.util.Log
import com.the_chance.domain.model.NewsArticle
import com.the_chance.domain.usecase.GetAllNewsByDateUseCase
import com.the_chance.domain.usecase.GetAllNewsUseCase
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.newswave.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getAllNewsUseCase: GetAllNewsUseCase,
    private val getAllNewsByDateUseCase: GetAllNewsByDateUseCase,
) : BaseViewModel<HomeUiState, HomeUiEffect>(HomeUiState()),
    HomeInteractionListener {
    override val TAG: String = this::class.java.simpleName

    init {
        getAllNewsArticle()
        getAllNewsByDate()
    }

    override fun getAllNewsArticle() {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            { getAllNewsUseCase() },
            ::onGetAllNewsSuccess,
            ::onGetAllNewsError
        )
    }

    override fun getAllNewsByDate() {
        _state.update { it.copy(isLoading = true, isError = false) }
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        tryToExecute(
            { getAllNewsByDateUseCase(date = currentDate) },
            ::onGetAllNewsByDateSuccess,
            ::onGetAllNewsByDateError
        )
    }

    private fun onGetAllNewsSuccess(news: List<NewsArticle>?) {
        if (!news.isNullOrEmpty()) {
            val newsWithImage = news.filter { !it.image.isNullOrEmpty() }
            _state.update {
                it.copy(
                    isLoading = false,
                    news = newsWithImage.map { newsArticle -> newsArticle.toNewsUiState() }
                )
            }
            Log.d("TAG", "Data fetched successfully")
        }
    }

    private fun onGetAllNewsByDateSuccess(currentNews: List<NewsArticle>?) {
        if (!currentNews.isNullOrEmpty()) {
            val currentNewsWithImage = currentNews.filter { !it.image.isNullOrEmpty() }
            _state.update {
                it.copy(
                    isLoading = false,
                    currentNews = currentNewsWithImage.map { newsArticle -> newsArticle.toNewsUiState() }
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

    private fun onGetAllNewsByDateError(error: ErrorHandler) {
        _state.update { it.copy(isLoading = false, error = error) }
        if (error is ErrorHandler.NoConnection) {
            _state.update { it.copy(isError = true) }
        }
    }

    override fun onClickSearchIcon() {
        effectActionExecutor(_effect, HomeUiEffect.NavigateToSearchScreenEffect)
    }

    override fun onClickWorldNews() {
        TODO("Not yet implemented")
    }

    override fun onClickBreakingNews() {
    }

    override fun onClickRecommendedNews() {
        TODO("Not yet implemented")
    }

    override fun onClickShowMore() {
        effectActionExecutor(_effect, HomeUiEffect.NavigateToSeeAllNewsEffect)
    }
}