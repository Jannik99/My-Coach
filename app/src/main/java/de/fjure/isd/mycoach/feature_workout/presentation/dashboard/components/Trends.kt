package de.fjure.isd.mycoach.feature_workout.presentation.dashboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.ui.theme.*

@Composable
fun Trends(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .background(DarkGrey)
            .wrapContentSize(Alignment.TopCenter)
            .border(1.dp, Ivory)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row() {
            Icon(
                Icons.Default.Add,
                contentDescription = "",
                modifier = Modifier.size(48.dp),
                tint = Blue
            )
            Column() {
                Text(text = "Trends positiv", color = Blue)
                Text(text = "5 Workouts mehr als letzten Monat", color = Blue)
            }

        }
        Row() {
            Icon(
                Icons.Default.Remove,
                contentDescription = "",
                modifier = Modifier.size(48.dp),
                tint = Red
            )
            Column() {
                Text(text = "Trends negativ", color = Red)
                Text(text = "10 min weniger Trainingszeit", color = Red)
            }

        }

    }
    Column(
    ) {


    }
}

@Preview(showBackground = true)
@Composable
fun TrendsPreview() {
    MyCoachTheme {
        Trends()
    }
}