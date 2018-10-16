package com.evaluacion2.presentation

import com.evaluacion2.business.entity.Student
import java.lang.StringBuilder
import javax.swing.JOptionPane

class AverageDialog(private val student: Student) {

    fun show() {
        JOptionPane.showMessageDialog(
                null,
                "Las notas de " +
                        student.name + " " + student.lastName + " son " + "\n"+
                        "Rut:"+ student.dni+ "\n" +
                        getRagtingsText(student) +
                        "con un promedio de " + "%.1f".format(student.ratings.average()),
                "Calculador de Promedio",

                JOptionPane.PLAIN_MESSAGE,
                null);
    }

    private fun getRagtingsText(student: Student): String {
        val ratingString = StringBuilder()

        for(rating in student.ratings) {
            ratingString.append(rating)
            ratingString.append("\n")
        }

        return ratingString.toString()
    }
}