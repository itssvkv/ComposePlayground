package com.example.composeplayground.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeplayground.screens.DetailScreen
import com.example.composeplayground.screens.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        route = ROOT_ROUTE
    )
    {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen()
        }

        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            Log.d("TAG", "SetupNavGraph: ${it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString()}")
            DetailScreen(navController = navController)

        }

        authNavGraph(navController = navController)

    }

}