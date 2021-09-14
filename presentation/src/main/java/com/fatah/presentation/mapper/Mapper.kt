package com.fatah.presentation.mapper

interface Mapper<E, T> {
    fun from(e: E): T

    fun to(t: T): E
}