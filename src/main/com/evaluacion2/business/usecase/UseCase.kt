package com.evaluacion2.business.usecase

interface UseCase<in Params, out T> {
    fun execute(params: Params) : T
}