package de.fjure.isd.mycoach.feature_workout.presentation.workout_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import de.fjure.isd.mycoach.feature_workout.model.Workout
import de.fjure.isd.mycoach.testWorkout
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.Grey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Typography


@Composable
fun WorkoutDetailsHeader(
    workout: Workout, modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .background(DarkGrey)
                .wrapContentSize(Alignment.TopCenter)
        ) {
            Box(
                modifier = Modifier
                    .zIndex(1f)
                    .wrapContentSize(Alignment.TopCenter)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        workout.imageUrl,
                    ),
                    contentDescription = "Titelbild von " + workout.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.TopCenter)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(2f)
                    .wrapContentSize(Alignment.Center)
                    .clip(shape = RoundedCornerShape(25))
                    .offset(y = 25.dp)
                    .padding(bottom = 25.dp)
            ) {
                Column(
                    modifier = Modifier
                        .width(300.dp)
                        .wrapContentSize(Alignment.Center)
                        .background(Grey.copy(alpha = 0.5f))
                        .padding(16.dp),
                ) {
                    Text(
                        text = workout.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center),
                        style = Typography.h1
                    )
                    Text(
                        text = workout.description,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center),
                        style = Typography.body1
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutDetailsHeaderPreview() {
    MyCoachTheme {
        WorkoutDetailsHeader(testWorkout)
    }
}