package com.evaluacion2

import com.evaluacion2.business.usecase.SearchStudentByLastName
import com.evaluacion2.data.repository.FileStudentRepository
import com.evaluacion2.presentation.SearchByLastNameForm
import com.evaluacion2.presentation.SearchForm

class Main

fun main(args: Array<String>) {

    SearchByLastNameForm.searchStudentByLastName = SearchStudentByLastName(FileStudentRepository)

    SearchForm.show()
}