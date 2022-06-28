package de.fjure.isd.mycoach.feature_workout.presentation.workout_details.active_workout.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.ui.theme.Ivory
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Red

@Composable
fun Timer(
) {
    Column(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            CircularProgressIndicator(
                progress = 1f, modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                strokeWidth = 25.dp,
                color = Ivory
            )
            CircularProgressIndicator(
                progress = 0.5f, modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                strokeWidth = 25.dp,
                color = Red
            )
            // Text(text = "", modifier = Modifier.wrapContentSize(Alignment.Center)) Timer
        }

    }
}


@Preview(showBackground = true)
@Composable
fun TimerPreview() {
    MyCoachTheme {
        Timer()
    }
}