package de.fjure.isd.mycoach.feature_workout.presentation.workouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.categories
import de.fjure.isd.mycoach.feature_workout.presentation.workouts.components.WorkoutListRow
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Typography
import de.fjure.isd.mycoach.workouts

@Composable
fun Workouts() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey)
            .wrapContentSize(Alignment.TopCenter)
            .verticalScroll(scrollState)
    ) {
        Text(text = "Workouts", style = Typography.h1)

        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (category in categories) {
                WorkoutListRow(
                    workouts = workouts.filter { it.category == category },
                    title = category,
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutsPreview() {
    MyCoachTheme {
        Workouts()
    }
}