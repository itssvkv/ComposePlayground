package com.example.composeplayground

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.customui.SwipeLib
import com.example.composeplayground.model.Person
import com.example.composeplayground.navigation.SetupNavGraph
import com.example.composeplayground.permissiontest.RequestPermission
import com.example.composeplayground.screens.SearchViewModel
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    private val searchViewModel by viewModels<SearchViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposePlaygroundTheme {
                RequestPermission(permission = Manifest.permission.READ_CONTACTS)

            }

        }

    }

}

@Composable
fun Swipe() {
    val archive = SwipeAction(
        onSwipe = {
            Log.d("TAG", "onCreate: Archive")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Color.White
            )
        },
        background = Color.Green
    )

    val email = SwipeAction(
        onSwipe = {
            Log.d("TAG", "onCreate: Email")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Email,
                contentDescription = "Delete",
                tint = Color.White
            )
        },
        background = Color.Blue
    )
    SwipeableActionsBox(
        startActions = listOf(archive),
        endActions = listOf(email)
    ) {
        SwipeLib(
            person = Person(
                id = 1,
                firstName = "John",
                lastName = "Doe",
                age = 25
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePlaygroundTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}