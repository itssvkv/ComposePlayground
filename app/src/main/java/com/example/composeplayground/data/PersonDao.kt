package com.example.composeplayground.data

import androidx.room.Dao
import androidx.room.Query
import com.example.composeplayground.model.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun readAll(): Flow<List<Person>>
}