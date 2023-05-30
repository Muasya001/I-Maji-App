package com.example.kplc2
sealed class Screen(val route: String) {
    object ReportScreen : Screen(route = "reportScreen")
    object SuccessScreen : Screen(route = "successScreen"){
        fun passArgument (): String {
            return "SuccessScreen"
        }

    }

}