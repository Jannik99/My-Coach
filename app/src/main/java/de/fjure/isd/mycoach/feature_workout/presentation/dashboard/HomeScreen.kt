package de.fjure.isd.mycoach.feature_workout.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.feature_workout.presentation.dashboard.components.Trends
import de.fjure.isd.mycoach.feature_workout.presentation.workouts.components.WorkoutListRow
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Typography
import de.fjure.isd.mycoach.workouts

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey)
            .wrapContentSize(Alignment.TopStart)
    ) {
        Text(text = "Übersicht", style = Typography.h1)
        Spacer(modifier = Modifier.height(15.dp))
        Trends()
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Trainingsaktivitäten")
        Spacer(modifier = Modifier.height(100.dp))
        WorkoutListRow(workouts = workouts, "Zuletzt trainiert")
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyCoachTheme {
        HomeScreen()
    }
}