package com.example.composeplayground.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class OnePerson(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int

)
