package com.example.composeplayground.simpleapp

import androidx.lifecycle.ViewModel
import com.example.composeplayground.data.OnePersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    onePersonRepository: OnePersonRepository
) : ViewModel() {
    val readAll = onePersonRepository.readAll
}