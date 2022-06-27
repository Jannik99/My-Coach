package de.fjure.isd.mycoach.feature_workout.presentation.add_edit_workout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.commons.presentation.components.GenericButton
import de.fjure.isd.mycoach.feature_workout.domain.model.Exercise
import de.fjure.isd.mycoach.feature_workout.presentation.add_edit_workout.components.AddExerciseItem
import de.fjure.isd.mycoach.ui.theme.*

@Composable
fun AddWorkout() {
    val exercises: Array<Exercise> =
        arrayOf(
            Exercise(
                "1",
                "Bench Press",
                "Eine Leistungsübung",
                "https://modusx.de/wp-content/uploads/2021/01/bankdruecken-langhantel.jpg",
                2
            )
        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey)
            .wrapContentSize(Alignment.TopCenter)
    ) {
        Text(text = "Workout erstellen", style = Typography.h1)

        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            exercises.forEach { exercise ->
                AddExerciseItem(exercise)
                Icon(
                    Icons.Default.ExpandMore,
                    contentDescription = "",
                    modifier = Modifier.size(48.dp),
                    tint = Ivory
                )
            }
            Button(
                onClick = { /*TODO*/ },
                elevation = ButtonDefaults.elevation(0.dp),
            )
            {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "",
                    modifier = Modifier.size(48.dp)
                )
            }
        }


        Spacer(modifier = Modifier.weight(1f))

        GenericButton(
            color = Blue,
            text = "Fertig",
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)

        )

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun AddWorkoutPreview() {
    MyCoachTheme {
        AddWorkout()
    }
}