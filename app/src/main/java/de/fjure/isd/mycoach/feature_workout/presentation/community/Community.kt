package de.fjure.isd.mycoach.feature_workout.presentation.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import de.fjure.isd.mycoach.feature_workout.model.User
import de.fjure.isd.mycoach.feature_workout.presentation.workouts.components.WorkoutListRow
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.Typography
import de.fjure.isd.mycoach.users
import de.fjure.isd.mycoach.workouts

@Composable
fun Community() {
    val user: User = users[0]
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey)
    ) {
        Text(text = "Community", style = Typography.h1)
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .wrapContentSize(Alignment.TopCenter)
            ) {
                AsyncImage(
                    model = user.profileImage, contentDescription = "", modifier = Modifier
                        .clip(
                            CircleShape
                        )
                        .size(100.dp),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Dein Profil")
            }

        }

        Spacer(modifier = Modifier.weight(1f))
        WorkoutListRow(workouts = workouts, "Zuletzt trainiert")
    }
}