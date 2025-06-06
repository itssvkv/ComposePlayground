package com.example.composeplayground.di

import android.content.Context
import androidx.room.Room
import com.example.composeplayground.data.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PersonDatabase::class.java,
        "person_database"

    ).build()

    @Singleton
    @Provides
    fun provideDao(database: PersonDatabase) = database.personDao()

}