package com.example.kplc2

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ReportScreen.route) {
        composable(Screen.ReportScreen.route) {
            ReportScreen(navController = navController)
        }
        composable(
            route = Screen.SuccessScreen.route,
            arguments = listOf(navArgument("report") {
                type = NavType.ParcelableType(ReportArgs::class.java)
            })
        ) { backStackEntry ->
            val reportArgs = backStackEntry.arguments?.getParcelable<ReportArgs>("report")
            reportArgs?.report?.let { report ->
                SuccessScreen(navController = navController, report = report)
            }
        }
        // Add the destination for the successScreen
        composable(Screen.SuccessScreen.route) {
// Handle the case when the successScreen is directly navigated to
// without providing a report argument
// You can display an error message or navigate back to the appropriate screen
        }
    }
}