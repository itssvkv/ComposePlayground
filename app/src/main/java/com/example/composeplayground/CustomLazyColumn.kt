package com.example.composeplayground

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.repository.PersonRepository

@Composable
fun CustomLazyColumn() {
    val personRepository = PersonRepository()
    val getAllData = personRepository.getAllData()

    LazyColumn() {
        items(items = getAllData) { person ->
            CustomRow(person = person)
        }
    }


}


@Preview
@Composable
fun CustomLazyColumnPreview() {
    CustomLazyColumn()
}