package de.fjure.isd.mycoach.feature_workout.presentation.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import de.fjure.isd.mycoach.R
import de.fjure.isd.mycoach.feature_workout.presentation.workouts.components.WorkoutItem
import de.fjure.isd.mycoach.ui.theme.Coral
import de.fjure.isd.mycoach.ui.theme.DarkGrey

@Composable
fun Community() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(text = "Community")
    }
}