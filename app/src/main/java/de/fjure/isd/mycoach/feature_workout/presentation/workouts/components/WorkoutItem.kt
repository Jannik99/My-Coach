package de.fjure.isd.mycoach.feature_workout.presentation.workouts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.R
import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.model.WorkoutCategory

@Composable
fun WorkoutItem(
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
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    onWorkoutClick: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .clickable { onWorkoutClick },
        elevation = 10.dp
    ) {
        Box(contentAlignment = Alignment.BottomStart) {
            Image(
                painter = painterResource(id = R.drawable.yoga),
                contentDescription = null
            )
            Text(
                text = "Test",
                color = Color.White,
                style = MaterialTheme.typography.h2
            )
        }
    }
}

@Preview
@Composable
fun WorkoutItemPreview() {
    WorkoutItem()
}