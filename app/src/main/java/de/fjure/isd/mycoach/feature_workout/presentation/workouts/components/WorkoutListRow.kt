package de.fjure.isd.mycoach.feature_workout.presentation.workouts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import de.fjure.isd.mycoach.feature_workout.model.Workout
import de.fjure.isd.mycoach.feature_workout.presentation.workout_details.WorkoutDetails
import de.fjure.isd.mycoach.feature_workout.presentation.workout_details.active_workout.ActiveWorkout
import de.fjure.isd.mycoach.testWorkout
import de.fjure.isd.mycoach.ui.theme.DarkGrey

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WorkoutListRow(workouts: List<Workout>, title: String = "", modifier: Modifier = Modifier) {
    val showDialog = remember { mutableStateOf(false) }
    val detailedWorkout = remember { mutableStateOf(testWorkout) }
    val workoutActive = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    Column() {
        Text(
            text = title,
            style = typography.h4,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkGrey)
                .horizontalScroll(scrollState)
                .height(150.dp)
        ) {
            workouts.forEach { workout ->
                WorkoutItem(
                    workout,
                    onWorkoutClick = {
                        detailedWorkout.value = workout
                        showDialog.value = true
                    },
                )
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
    }
    if (showDialog.value) {
        Dialog(
            onDismissRequest = { showDialog.value = false },
            DialogProperties(usePlatformDefaultWidth = false)
        ) {
            if (!workoutActive.value) {
                WorkoutDetails(
                    workout = detailedWorkout.value,
                    onDismiss = {
                        showDialog.value = false
                        workoutActive.value = false
                    },
                    onStartWorkout = {
                        workoutActive.value = true
                    }
                )
            } else
                ActiveWorkout(
                    workout = detailedWorkout.value,
                    onDismiss = {
                        showDialog.value = false
                        workoutActive.value = false
                    },
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutListRowPreview() {

    WorkoutListRow(workouts = listOf(testWorkout))

}
