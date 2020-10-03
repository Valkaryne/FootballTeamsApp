package com.epam.valkaryne.footballteamsapp.common.datatype

/**
 * Wrapper class over the result between application layers
 */
data class Result<out T>(
    val resultType: ResultType,
    val data: T? = null,
    val error: Exception? = null
) {

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(ResultType.SUCCESS, data)
        }

        fun <T> error(error: Exception? = null): Result<T> {
            return Result(ResultType.ERROR, error = error)
        }
    }
}

enum class ResultType {
    ERROR,
    SUCCESS
}