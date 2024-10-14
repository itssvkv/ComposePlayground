package com.example.composeplayground.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.model.Person
import com.example.composeplayground.navigation.Screen

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                val person = Person(id = 1, firstName = "John", lastName = "Doe", age = 25)
                sharedViewModel.addPerson(newPerson = person)
                navHostController.navigate(Screen.DetailScreen.passID(id = 1))
//                navHostController.currentBackStackEntry?.savedStateHandle?.set(
//                    key = "person",
//                    value = person
//                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(

            text = "Home",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {

}