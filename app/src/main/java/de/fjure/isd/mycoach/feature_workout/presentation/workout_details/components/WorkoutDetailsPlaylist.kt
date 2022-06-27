package de.fjure.isd.mycoach.feature_workout.presentation.workout_details.components

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
import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.model.WorkoutCategory
import de.fjure.isd.mycoach.ui.theme.Grey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Typography

@Composable
fun WorkoutDetailsPlaylist(
    workout: Workout, modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .background(Grey.copy(alpha = 0.5f))
            .padding(16.dp),
    ) {

        Image(
            painter = rememberAsyncImagePainter(
                workout.imageURL,
            ),
            contentDescription = "Titelbild von " + workout.name,
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center)

        ) {
            Text(
                text = "Empfohlene Playlist",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                style = Typography.h1
            )
            Text(
                text = "Lorem Ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
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
fun WorkoutDetailsPlaylistPreview() {
    MyCoachTheme {
        WorkoutDetailsPlaylist(
            Workout(
                name = "test",
                description = "test beschreibung",
                category = WorkoutCategory.Popular,
                createdAt = 1L,
                lastWorkedOut = 1L,
                playList = "https://youtu.be/dQw4w9WgXcQ",
                imageURL = "https://www.yogabox.de/blog/wp-content/uploads/2019/10/yoga-unsplash.com_-1024x646.jpg",
                id = 1
            )
        )
    }
}