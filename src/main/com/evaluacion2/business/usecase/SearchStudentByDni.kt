package com.evaluacion2.business.usecase

import com.evaluacion2.business.entity.Student
import com.evaluacion2.business.repository.StudentRepository
import com.evaluacion2.utils.RutHelper

class SearchStudentByDni(private val studentRepository: StudentRepository) : UseCase<String, Student?> {

    override fun execute(params: String): Student? {
        return if (RutHelper.isValid(params)) {
            val completeDni = RutHelper.checkDigit(params)
            studentRepository.searchByFilter { it?.dni.equals(params) }
        } else
            null
    }
}