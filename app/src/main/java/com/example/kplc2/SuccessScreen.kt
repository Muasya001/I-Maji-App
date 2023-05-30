package com.example.kplc2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/*@Composable
fun SuccessScreen(navController: NavController, report: PowerOutageReport) {
    val location = remember { navController.previousBackStackEntry?.arguments?.getString("location") }
    val description = remember { navController.previousBackStackEntry?.arguments?.getString("description") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Power Outage Reported!", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Location: $location")
        Text(text = "Description: $description")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val reportArgs = ReportArgs(report)
                navController.navigate("${Screen.SuccessScreen.route}/${reportArgs.report.location}/${reportArgs.report.description}")
            }

        ) {
            Text(text = "OK")
        }
    }
}*/
@Composable
fun SuccessScreen(navController: NavController, report: PowerOutageReport) {
    val location = remember { navController.previousBackStackEntry?.arguments?.getString("location") }
    val description = remember { navController.previousBackStackEntry?.arguments?.getString("description") }

    // so that I can Send email when the SuccessScreen is first displayed
    LaunchedEffect(Unit) {
        EmailSender.sendEmail(report)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Power Outage Reported!", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Location: $location")
        Text(text = "Description: $description")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val reportArgs = ReportArgs(report)
                navController.navigate("${Screen.SuccessScreen.route}/${reportArgs.report.location}/${reportArgs.report.description}")
            }
        ) {
            Text(text = "OK")
        }
    }
}







