package com.example.nytimesmostpopulararticles.api

sealed class ResultException(
    val messageResource: Int = 0,
    val errorCode: Int = 0,
    message: String = ""
) : RuntimeException(message) {

    class Connection(messageResource: Int) :
        ResultException(messageResource = messageResource)

    class Timeout(messageResource: Int) :
        ResultException(messageResource = messageResource)

    class Unexpected(messageResource: Int, errorCode: Int = 0) :
        ResultException(messageResource, errorCode)

    class Server(messageResource: Int, errorCode: Int) : ResultException(messageResource, errorCode)

    class Client(messageResource: Int = 0, errorCode: Int) :
        ResultException(messageResource, errorCode)

    class ApiError(errorCode: Int = 0, message: String) :
        ResultException(errorCode = errorCode, message = message)
}
