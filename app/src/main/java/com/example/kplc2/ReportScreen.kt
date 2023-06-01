package com.example.kplc2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReportScreen(navController: NavController) {
    var report by remember { mutableStateOf(PowerOutageReport("", "")) }
    Image(painterResource(id = R.drawable.kenyapower2),
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = " Report power outage ", style = MaterialTheme.typography.h6,
        fontWeight = FontWeight(7)
        )
        Spacer(modifier = Modifier.height(16.dp))
        report.location?.let {
            OutlinedTextField(modifier = Modifier.background(color = Color.Blue),
                value = it,
                onValueChange = { location -> report = report.copy(location = location) },
                label = { Text("Location") }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(modifier = Modifier.background(color = Color.Blue),
            value = report.description.toString(),
            onValueChange = { description -> report = report.copy(description = description) },
            label = { Text("Description") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(Screen.SuccessScreen.route) {
                    //Here I will Pass the report object as a parameter to the SuccessScreen
                    launchSingleTop = true
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    ReportArgs(report)
                }
            }
        ) {
            Text(text = "Click here to Submit Report")
        }
    }
}
