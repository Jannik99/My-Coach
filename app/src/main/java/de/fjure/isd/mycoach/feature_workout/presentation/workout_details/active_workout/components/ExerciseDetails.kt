package de.fjure.isd.mycoach.feature_workout.presentation.workout_details.active_workout.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import de.fjure.isd.mycoach.feature_workout.model.Exercise
import de.fjure.isd.mycoach.testWorkout
import de.fjure.isd.mycoach.ui.theme.Grey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Typography

@Composable
fun ExerciseDetails(
    exercise: Exercise, modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .background(Grey.copy(alpha = 0.5f))
            .padding(16.dp),
    ) {

        Image(
            painter = rememberAsyncImagePainter(
                exercise.imageUrl,
            ),
            contentDescription = "Titelbild von " + exercise.name,
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.TopCenter)
        )
        Spacer(modifier = Modifier.width(15.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center)

        ) {
            Text(
                text = exercise.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                style = Typography.h1
            )
            Text(
                text = exercise.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                style = Typography.body1
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseDetailsPreview() {
    MyCoachTheme {
        ExerciseDetails(
            testWorkout.exercises[0],
        )
    }
}