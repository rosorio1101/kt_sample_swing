package com.evaluacion2.business.usecase

import com.evaluacion2.business.entity.Student
import com.evaluacion2.business.repository.StudentRepository

class SearchStudentByLastName(val studentRepository: StudentRepository) : UseCase<String, Student?> {

    override fun execute(params: String): Student? {
        return studentRepository.searchByFilter { it?.lastName.equals(params) }
    }
}