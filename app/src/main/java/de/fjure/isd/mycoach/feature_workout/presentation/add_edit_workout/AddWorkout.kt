package de.fjure.isd.mycoach.feature_workout.presentation.add_edit_workout

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.fjure.isd.mycoach.R
import de.fjure.isd.mycoach.feature_workout.presentation.Greeting
import de.fjure.isd.mycoach.feature_workout.presentation.workouts.components.WorkoutItem
import de.fjure.isd.mycoach.ui.theme.Blue
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Typography

@Composable
fun AddWorkout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey)
            .wrapContentSize(Alignment.TopCenter)
    ) {
        Text(text = "Workout erstellen", style = Typography.h1)

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue, contentColor = Color.White),
            shape = RoundedCornerShape(40),
            modifier = Modifier
                .width(350.dp)
                .height(50.dp)
                    ) {
            Text(text = "Fertig", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun AddWorkoutPreview() {
    MyCoachTheme {
        AddWorkout()
    }
}