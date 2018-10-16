package com.evaluacion2.business.repository

interface Repository<ENTITY> {
    fun searchByFilter(filter: Filter<ENTITY>): ENTITY
}

typealias Filter<ENTITY> = (ENTITY) -> Boolean