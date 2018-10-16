package com.evaluacion2.presentation

import com.evaluacion2.business.usecase.SearchStudentByDni
import javax.swing.JOptionPane

object SearchByDniForm {

    lateinit var searchStudentByDni: SearchStudentByDni

    fun show() {
        val dni = JOptionPane.showInputDialog(
                null,
                "Ingrese el Rut a buscar\nDebe ser un Rut válido",
                null)

        if (dni.isNotEmpty()) {
            val student = searchStudentByDni.execute(dni)
            if (student != null) {
                AverageDialog(student).show()
            }
        } else {
            show()
        }
    }
}