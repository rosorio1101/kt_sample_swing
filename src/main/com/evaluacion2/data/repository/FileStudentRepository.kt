package com.evaluacion2.data.repository

import com.evaluacion2.business.entity.Student
import com.evaluacion2.business.repository.Filter
import com.evaluacion2.business.repository.StudentRepository
import java.io.File
import java.sql.Time
import java.time.LocalDateTime
import java.time.LocalTime

object FileStudentRepository : StudentRepository {

    private var students: List<Student?> = emptyList()
    private val file = this::class.java.classLoader.getResource("students.txt")

    init {

        students = readStudentsFromFile(file.path)
        print(students.size)
    }

    override fun searchByFilter(filter: Filter<Student?>): Student? {
        for(student in students) {
            if (filter.invoke(student))
                return student
        }

        return null
    }

    private fun readStudentsFromFile(filePath: String): List<Student?> = File(filePath).useLines {
        val startime = Time.valueOf(LocalTime.now())
        println("Begin reading ${filePath}")
        var students = listOf<Student?>()

        for (line in it.iterator()) {
            students += readStudent(line.replace(";", ""))
            println("reading ${students.size}")
        }
        val endTime = Time.valueOf(LocalTime.now())
        val diff = difference(startime, endTime)
        println("End reading ${filePath} - ${diff.hours}:${diff.minutes}:${diff.seconds}")
        return students
    }

    private fun readStudent(studentData: String): Student? {
        val splitData = studentData.split(",")
        if (splitData.isNotEmpty()) {
            val dni = splitData[0]
            val fullName = splitData[1]
            val ratings = splitData.subList(2, splitData.size).map { it.toDouble() }.toTypedArray()
            val splitFullName = fullName.split(" ")
            val firstName = splitFullName[0]
            val lastName = if (splitFullName.size > 2)
                splitFullName[1] + " " + splitFullName[2]
            else splitFullName[1]

            return Student(dni, firstName, lastName, ratings)

        }
        return null
    }

    fun difference(start: Time, stop: Time): Time {
        val diff = Time(0, 0, 0)

        if (stop.seconds > start.seconds) {
            --start.minutes
            start.seconds += 60
        }

        diff.seconds = start.seconds - stop.seconds
        if (stop.minutes > start.minutes) {
            --start.hours
            start.minutes += 60
        }

        diff.minutes = start.minutes - stop.minutes
        diff.hours = start.hours - stop.hours

        return diff
    }
}