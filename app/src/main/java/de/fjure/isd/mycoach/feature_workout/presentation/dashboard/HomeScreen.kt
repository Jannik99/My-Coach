package de.fjure.isd.mycoach.feature_workout.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.fjure.isd.mycoach.feature_workout.presentation.workouts.components.WorkoutItem
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.workouts

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(text = "Home")
        WorkoutItem(workout = workouts[0])
    }
}