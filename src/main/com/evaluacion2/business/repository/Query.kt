package com.evaluacion2.business.repository

interface Query<T> {
    fun apply(data: T)
}