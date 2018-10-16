package com.evaluacion2.presentation

import javax.swing.JOptionPane

object SearchForm {
    val options = arrayOf("Apellido", "Rut", "Salir")

    fun show() {
        val option = JOptionPane.showInputDialog(
                null,
                "Bienvenido al buscador de notas\nSeleccione como desea buscar al alumno: ",
                "Buscar en un archivo. Franco Castro V.",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "Apellido"
        )

        when(option) {
            options[0] -> {
                SearchByLastNameForm.show()
            }
            options[1] -> {
                println("Seleccionado Rut")
            }
            options[2] -> {
                println("Seleccionado Salir")
            }
        }
    }
}