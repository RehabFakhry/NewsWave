package com.the_chance.domain.utill


open class AuthenticationException : Exception()
class UnAuthorizedException : AuthenticationException()
class NotValidApiKeyException : AuthenticationException()
class ForbiddenException : AuthenticationException()
class UnAuthorizedCredential : AuthenticationException()


open class NetworkException : Exception()
class NoConnectionException : NetworkException()

sealed interface ErrorHandler {

    object NoConnection : ErrorHandler
    object NotFound : ErrorHandler
    object UnAuthorizedUser : ErrorHandler
    object UnKnownError : ErrorHandler
}

fun handelNetworkException(
    exception: NetworkException,
    onError: (t: ErrorHandler) -> Unit,
) {
    when (exception) {
        is NoConnectionException -> onError(ErrorHandler.NoConnection)
    }
}
