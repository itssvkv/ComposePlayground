package com.example.composeplayground.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Person(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int

):Parcelable
