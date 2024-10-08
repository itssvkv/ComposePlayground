package com.example.composeplayground.navigation


const val DETAIL_ARGUMENT_KEY = "id"
const val ROOT_ROUTE = "root"
const val AUTH_ROUTE = "auth"

sealed class Screen(val route: String) {
    data object SplashScreen : Screen(route = "splash_screen")
    data object HomeScreen : Screen(route = "home_screen")
    data object DetailScreen : Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}") {
        fun passID(id: Int): String {
            return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
        }
    }

    data object LoginScreen : Screen(route = "login_screen")
    data object SignUpScreen : Screen(route = "signup_screen")

}