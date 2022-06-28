package de.fjure.isd.mycoach.feature_workout.presentation.workout_details.active_workout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.commons.presentation.components.GenericButton
import de.fjure.isd.mycoach.feature_workout.model.Workout
import de.fjure.isd.mycoach.feature_workout.presentation.workout_details.active_workout.components.ExerciseDetails
import de.fjure.isd.mycoach.testWorkout
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Red


@Composable
fun ActiveWorkout(
    workout: Workout,
    onDismiss: () -> Unit,

    ) {
    Column(
        modifier = Modifier
            .background(DarkGrey)
            .fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(15.dp))
        GenericButton(
            color = Red,
            text = "Workout stoppen",
            onClick = { onDismiss() },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Timer")
        Spacer(modifier = Modifier.weight(1f))
        ExerciseDetails(exercise = workout.exercises[0])
    }
}

@Preview(showBackground = true)
@Composable
fun ActiveWorkoutPreview() {
    MyCoachTheme {
        ActiveWorkout(testWorkout, onDismiss = {})
    }
}