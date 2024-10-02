package com.example.composeplayground.data

import javax.inject.Inject

class OnePersonRepository @Inject constructor(
    private val personDao: PersonDao
) {
    val readAll = personDao.readAll()
}