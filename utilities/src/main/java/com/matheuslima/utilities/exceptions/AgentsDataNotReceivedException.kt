package com.matheuslima.utilities.exceptions

class AgentsDataNotReceivedException(throwable: Throwable) :
    BaseException(throwable, ExceptionConstants.AGENT_DATA_FAILED_EXCEPTION)