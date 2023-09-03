package com.the_chance.newswave.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.the_chance.domain.utill.AuthenticationException
import com.the_chance.domain.utill.ErrorHandler
import com.the_chance.domain.utill.GeneralException
import com.the_chance.domain.utill.handelAuthenticationException
import com.the_chance.domain.utill.handelGeneralException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

abstract class BaseViewModel<T, E>(initialState: T) : ViewModel() {

    abstract val TAG: String
    protected open fun log(message: String) {
        Log.e(TAG, message)
    }

    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val _effect = MutableSharedFlow<E>()
    val effect = _effect.asSharedFlow()

    private var job: Job? = null


    protected fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (t: ErrorHandler) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = function()
//                log("RRR:$result ")
                onSuccess(result)
            } catch (exception: Exception) {
                log("tryToExecute error Exception: ${exception}")
                onError(ErrorHandler.NotFound)
            }
        }
    }
}