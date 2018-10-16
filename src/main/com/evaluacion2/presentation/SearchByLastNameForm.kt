package com.evaluacion2.presentation

import com.evaluacion2.business.usecase.SearchStudentByLastName
import javax.swing.JOptionPane

object SearchByLastNameForm {

    lateinit var searchStudentByLastName: SearchStudentByLastName

    fun show() {
        val lastName = JOptionPane.showInputDialog(
                null,
                "Ingrese el Apellido a buscar\nRespete mayúsculas y minúsculas",
                null)

        if (lastName.isNotEmpty()) {
            val student = searchStudentByLastName.execute(lastName)
            if (student != null) {
                AverageDialog(student).show()
            }
        } else {
            show()
        }
    }
}