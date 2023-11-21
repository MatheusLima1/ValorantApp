package com.matheuslima.utilities.exceptions

abstract class BaseException(throwable: Throwable?, message: String?) : Throwable(message, throwable)