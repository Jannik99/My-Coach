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
import de.fjure.isd.mycoach.json_data.JsonController
import de.fjure.isd.mycoach.ui.theme.Blue
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme

@Composable
fun WorkoutDetails(
    workout: Workout,
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
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
        )
        WorkoutDetailsPlaylist(workout = workout)
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutDetailsPreview() {
    MyCoachTheme {
        WorkoutDetails(JsonController().testWorkout)
    }
}