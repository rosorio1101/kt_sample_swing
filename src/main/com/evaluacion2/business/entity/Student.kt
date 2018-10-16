package com.evaluacion2.business.entity

data class Student(var dni: String,
                   var name: String,
                   var lastName: String,
                   var ratings: Array<Double>)