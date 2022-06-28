package de.fjure.isd.mycoach.feature_workout.presentation.workout_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.commons.presentation.components.GenericButton
import de.fjure.isd.mycoach.feature_workout.model.Workout
import de.fjure.isd.mycoach.feature_workout.presentation.workout_details.components.WorkoutDetailsHeader
import de.fjure.isd.mycoach.feature_workout.presentation.workout_details.components.WorkoutDetailsPlaylist
import de.fjure.isd.mycoach.testWorkout
import de.fjure.isd.mycoach.ui.theme.Blue
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Red

@Composable
fun WorkoutDetails(
    workout: Workout,
    onDismiss: () -> Unit,
    onStartWorkout: () -> Unit,

    ) {
    Column(
        modifier = Modifier
            .background(DarkGrey)
            .fillMaxSize()
    ) {
        WorkoutDetailsHeader(
            workout = workout,
            modifier = Modifier
                .height(300.dp)
        )
        GenericButton(
            color = Blue,
            text = "Workout starten",
            onClick = { onStartWorkout() },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
        )

        Spacer(modifier = Modifier.weight(1f))

        WorkoutDetailsPlaylist(workout = workout)
        Spacer(modifier = Modifier.height(10.dp))
        GenericButton(
            color = Red,
            text = "Abbrechen",
            onClick = { onDismiss() },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutDetailsPreview() {
    MyCoachTheme {
        WorkoutDetails(testWorkout, onDismiss = {}, onStartWorkout = {})
    }
}