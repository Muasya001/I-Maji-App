@file:Suppress("DEPRECATION")

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

    NavHost(navController = navController, startDestination = "reportScreen") {
        composable("reportScreen") {
            ReportScreen(navController= navController)
        }
        composable(
            route = "SuccessScreen",
            arguments = listOf(navArgument("report") { type =
                NavType.ParcelableType(ReportArgs::class.java)
            })
        ) { backStackEntry ->
            val reportArgs = backStackEntry.arguments?.getParcelable<ReportArgs>("report")
            reportArgs?.report?.let { report ->
                SuccessScreen(navController=navController, report)
            }
        }

    }
}
