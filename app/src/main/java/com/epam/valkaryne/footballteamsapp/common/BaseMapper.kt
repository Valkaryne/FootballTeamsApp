package com.epam.valkaryne.footballteamsapp.common

/**
 * Mapper interface to transform one data type to another.
 *
 * @param <A> the type of the input
 * @param <B> the type of the result of mapping
 */
interface BaseMapper<in A, out B> {

    /**
     * Transforms given model to chosen.
     *
     * @param model the given model
     * @return the mapping result
     */
    fun map(model: A?): B
}