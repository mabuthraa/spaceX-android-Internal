package com.epam.spacex.data.common.mapper

interface Mapper<in T, out R> {
    fun map(origin: T): R

    //convert any null collection into empty for better/safer handling on UI
    fun map(origin: List<T>?): List<R> {
        return origin?.map(::map) ?: emptyList()
    }
}