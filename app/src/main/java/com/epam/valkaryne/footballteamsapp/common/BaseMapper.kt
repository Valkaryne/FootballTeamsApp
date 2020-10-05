package com.epam.valkaryne.footballteamsapp.common

/**
 * Mapper interface to transform one data type to another.
 *
 * @param <A> the type of the input
 * @param <B> the type of the result of mapping
 */
interface BaseMapper<in A, out B> {

    /**
     * Transforms given model type to chosen.
     *
     * @param modelType the given model type
     * @return the mapping result
     */
    operator fun invoke(modelType: A?): B
}