package com.the_chance.domain.utill

open class GeneralException : Exception()
class InvalidDataException : GeneralException()
class NotFoundException : GeneralException()

open class AuthenticationException : Exception()
class UnAuthorizedException : AuthenticationException()
class NotValidApiKeyException : AuthenticationException()
class ForbiddenException : AuthenticationException()
class UnAuthorizedCredential : AuthenticationException()


sealed interface ErrorHandler {

    object NoConnection : ErrorHandler
    object InvalidData : ErrorHandler
    object NotFound : ErrorHandler
    object UnAuthorizedUser : ErrorHandler
    object UnKnownError : ErrorHandler
}



fun handelAuthenticationException(
    exception: AuthenticationException,
    onError: (t: ErrorHandler) -> Unit,
) {
    when (exception) {

        is ForbiddenException -> onError(ErrorHandler.UnAuthorizedUser)

        is UnAuthorizedException -> onError(ErrorHandler.UnAuthorizedUser)

        is UnAuthorizedCredential -> onError(ErrorHandler.UnAuthorizedUser)

        is NotValidApiKeyException -> onError(ErrorHandler.UnKnownError)

    }
}

fun handelGeneralException(
    exception: GeneralException,
    onError: (t: ErrorHandler) -> Unit,
) {
    when (exception) {
        is InvalidDataException -> onError(ErrorHandler.InvalidData)

        is NotFoundException -> onError(ErrorHandler.NotFound)
    }
}