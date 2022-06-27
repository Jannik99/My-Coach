package de.fjure.isd.mycoach.feature_workout.presentation.add_edit_workout.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import de.fjure.isd.mycoach.feature_workout.model.Exercise
import de.fjure.isd.mycoach.json_data.JsonController
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.Ivory

@Composable
fun AddExerciseItem(exercise: Exercise) {
    Row(
        modifier = Modifier
            .background(DarkGrey)
            .wrapContentSize(Alignment.TopCenter)
            .fillMaxWidth()
            .height(200.dp)
            .border(color = Ivory, width = 1.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Image(
                painter = rememberAsyncImagePainter(exercise.imageUrl),
                contentDescription = exercise.name,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = exercise.name,
                style = typography.h6,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = exercise.description,
                style = typography.body1,
                modifier = Modifier.padding(16.dp)
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text("Anzahl Ausführungen:")

            TextField(
                value = exercise.executions.toString(),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                onValueChange = {
                    // Funktioniert nicht, wegen Mutable State Gedöns. To be Done.
                    if (it.isNotEmpty()) {
                        exercise.executions = it.toInt()
                    } else {
                        exercise.executions = 0
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddExerciseItemPreview() {
    AddExerciseItem(JsonController().testWorkout.exercises[0])
}