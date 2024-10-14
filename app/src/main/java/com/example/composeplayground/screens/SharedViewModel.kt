package com.example.composeplayground.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composeplayground.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class SharedViewModel @Inject constructor() : ViewModel() {
    var person by mutableStateOf<Person?>(null)
        private set
    fun addPerson(newPerson: Person){
        person = newPerson
    }
}