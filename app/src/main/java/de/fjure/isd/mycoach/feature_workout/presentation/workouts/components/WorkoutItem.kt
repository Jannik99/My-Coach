package de.fjure.isd.mycoach.feature_workout.presentation.workouts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import de.fjure.isd.mycoach.feature_workout.model.Workout
import de.fjure.isd.mycoach.testWorkout
import de.fjure.isd.mycoach.ui.theme.Ivory

@Composable
fun WorkoutItem(
    workout: Workout,
    modifier: Modifier = Modifier,
    onWorkoutClick: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .clickable { onWorkoutClick() },
        elevation = 0.dp
    ) {
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .border(width = 1.dp, color = Ivory)
                .width(220.dp)
                .height(150.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = workout.imageUrl),
                contentDescription = workout.name,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = workout.name,
                color = Color.White,
                style = typography.h5
            )
        }
    }
}

@Preview
@Composable
fun WorkoutItemPreview() {
    WorkoutItem(
        workout = testWorkout,
        onWorkoutClick = {}
    )
}