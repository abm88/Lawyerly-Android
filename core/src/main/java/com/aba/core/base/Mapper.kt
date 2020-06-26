package com.aba.core.base

interface LocalMapper<T, R> {
    fun mapToLocal(items: R):T
    fun mapFromLocal(items: T): R
}

interface RemoteMapper<T, R> {
    fun map(items: T): R
}