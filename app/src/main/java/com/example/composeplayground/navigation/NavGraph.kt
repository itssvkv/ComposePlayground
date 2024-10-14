package com.example.composeplayground.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeplayground.model.Person
import com.example.composeplayground.screens.AnimatedSplashScreen
import com.example.composeplayground.screens.DetailScreen
import com.example.composeplayground.screens.HomeScreen
import com.example.composeplayground.screens.SharedViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        route = ROOT_ROUTE
    )
    {
        composable(
            route = Screen.SplashScreen.route
        ) {
            AnimatedSplashScreen(navHostController = navController)
        }
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navHostController = navController, sharedViewModel = sharedViewModel)
        }

        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            Log.d("TAG", "SetupNavGraph: ${it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString()}")
//            LaunchedEffect(key1 = it) {
//                val result = navController.previousBackStackEntry?.savedStateHandle?.get<Person>(
//                    key = "person"
//                )
//                Log.d("TAG", "SetupNavGraph: ${result?.firstName}")
//            }
            DetailScreen(navController = navController, sharedViewModel = sharedViewModel)

        }

        authNavGraph(navController = navController)

    }

}