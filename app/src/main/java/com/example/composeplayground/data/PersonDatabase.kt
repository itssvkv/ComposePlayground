package com.example.composeplayground.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeplayground.model.Person

@Database(entities = [Person::class], version = 1, exportSchema = true)
abstract class PersonDatabase : RoomDatabase(){
    abstract fun personDao(): PersonDao
}