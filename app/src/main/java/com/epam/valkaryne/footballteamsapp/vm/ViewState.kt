package com.epam.valkaryne.footballteamsapp.vm

sealed class ViewState<out S, out F> {

    object Loading : ViewState<Nothing, Nothing>()

    data class Success<out S>(val data: S) : ViewState<S, Nothing>()

    data class Error<out F>(val error: F) : ViewState<Nothing, F>()
}