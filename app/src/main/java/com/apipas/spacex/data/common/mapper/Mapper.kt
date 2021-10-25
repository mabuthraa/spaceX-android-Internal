package com.apipas.spacex.data.common.mapper

interface Mapper<in T, out R> {
    fun map(origin: T): R

    fun map(origin: List<T>): List<R> {
        return origin.map(::map)
    }
}