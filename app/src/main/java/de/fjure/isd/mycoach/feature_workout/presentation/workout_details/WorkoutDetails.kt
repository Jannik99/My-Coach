package de.fjure.isd.mycoach.feature_workout.presentation.workout_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.commons.presentation.components.GenericButton
import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.model.WorkoutCategory
import de.fjure.isd.mycoach.feature_workout.presentation.workout_details.components.WorkoutDetailsHeader
import de.fjure.isd.mycoach.feature_workout.presentation.workout_details.components.WorkoutDetailsPlaylist
import de.fjure.isd.mycoach.ui.theme.Blue
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme

@Composable
fun WorkoutDetails(
    workout: Workout = Workout(
        name = "test",
        description = "test beschreibung",
        category = WorkoutCategory.Popular,
        createdAt = 1L,
        lastWorkedOut = 1L,
        id = 1,
        playList = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
        imageURL = "https://www.yogabox.de/blog/wp-content/uploads/2019/10/yoga-unsplash.com_-1024x646.jpg",
    ),
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
        WorkoutDetails()
    }
}