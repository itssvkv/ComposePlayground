package com.example.composeplayground.repository

import com.example.composeplayground.model.Person

class PersonRepository {
    fun getAllData(): List<Person> {
        return listOf(
            Person(id = 1, firstName = "John", lastName = "Doe", age = 25),
            Person(id = 2, firstName = "Jane", lastName = "Doe", age = 30),
            Person(id = 3, firstName = "Michael", lastName = "Smith", age = 28),
            Person(id = 4, firstName = "Emily", lastName = "Johnson", age = 35),
            Person(id = 5, firstName = "David", lastName = "Brown", age = 22),
            Person(id = 6, firstName = "John", lastName = "White", age = 27),
            Person(id = 7, firstName = "Michael", lastName = "Green", age = 32),
            Person(id = 8, firstName = "Emily", lastName = "Black", age = 29),
            Person(id = 9, firstName = "David", lastName = "Red", age = 24),
            Person(id = 10, firstName = "John", lastName = "Blue", age = 31)
        )
    }
}