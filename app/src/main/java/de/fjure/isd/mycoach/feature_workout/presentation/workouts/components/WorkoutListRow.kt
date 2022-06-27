package de.fjure.isd.mycoach.feature_workout.presentation.workouts.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import de.fjure.isd.mycoach.feature_workout.domain.model.Workout

@Composable
fun WorkoutListRow(workouts: Array<Workout>) {
    Row {
        workouts.forEach { workout ->
            WorkoutItem(workout)
        }
    }
}