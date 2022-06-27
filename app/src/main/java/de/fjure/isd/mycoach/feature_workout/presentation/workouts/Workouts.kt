package de.fjure.isd.mycoach.feature_workout.presentation.workouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.fjure.isd.mycoach.ui.theme.DarkGrey

@Composable
fun Workouts() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey)
            .wrapContentSize(Alignment.Center)
    ) {
        // Vertical Scrollable List of WorkoutListRow
    
    }
}