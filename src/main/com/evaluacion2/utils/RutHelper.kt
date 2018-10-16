package com.evaluacion2.utils

object RutHelper {
    fun isValid(rut: String): Boolean {
        var validacion = false
        try {
            rut.apply {
                toUpperCase()
                replace(".", "")
                replace(".", "")
            }
            var rutAux = Integer.parseInt(rut.substring(0, rut.length - 1))

            val dv = rut.get(rut.length - 1)

            var m = 0
            var s = 1
            while (rutAux != 0) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11
                rutAux /= 10
            }
            if (dv == (if (s != 0) s + 47 else 75).toChar()) {
                validacion = true
            }

        } catch (e: java.lang.NumberFormatException) {
        } catch (e: Exception) {
        }

        return validacion
    }

    fun checkDigit(rut: String) {

    }
}