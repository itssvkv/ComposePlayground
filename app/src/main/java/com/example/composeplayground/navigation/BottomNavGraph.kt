package com.example.composeplayground.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeplayground.screens.HomeScreen
import com.example.composeplayground.screens.ProfileScreen
import com.example.composeplayground.screens.SearchViewModel
import com.example.composeplayground.screens.SettingsScreen
import com.example.composeplayground.screens.SharedViewModel

@Composable
fun BottomNavGraph(

    navController: NavHostController,
    sharedViewModel: SharedViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(
            route = BottomBarScreen.Home.route
        ){
            HomeScreen(navHostController = navController, sharedViewModel)
        }
        composable(
            route = BottomBarScreen.Profile.route
        ){
            ProfileScreen()
        }
        composable(
            route = BottomBarScreen.Settings.route
        ){
            SettingsScreen()
        }
    }
}