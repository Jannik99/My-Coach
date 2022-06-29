package de.fjure.isd.mycoach.feature_workout.presentation.add_edit_workout.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import de.fjure.isd.mycoach.feature_workout.model.Exercise
import de.fjure.isd.mycoach.testWorkout
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.Ivory

@Composable
fun AddExerciseItem(exercise: Exercise, onExerciseChanged: (Exercise) -> Unit) {
    var name = remember {
        mutableStateOf(exercise.name)
    }
    var description = remember {
        mutableStateOf(exercise.description)
    }
    var imageUrl = remember {
        mutableStateOf(exercise.imageUrl)
    }
    var executions = remember {
        mutableStateOf(exercise.executions)
    }

    fun exerciseChanged() {
        onExerciseChanged(
            Exercise(
                exercise.id,
                name.value,
                description.value,
                imageUrl.value,
                executions.value
            )
        )
    }

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
                painter = rememberAsyncImagePainter(imageUrl.value),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            TextField(
                value = name.value,
                modifier = Modifier.padding(16.dp),
                label = { Text(text = "Name") },
                onValueChange = {
                    name.value = it
                    exerciseChanged()
                },
            )
            TextField(
                value = description.value,
                modifier = Modifier.padding(16.dp),
                label = { Text(text = "Beschreibung") },
                onValueChange = {
                    description.value = it
                    exerciseChanged()
                },
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            TextField(
                value = executions.value.toString(),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Anzahl Audführungen") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                onValueChange = {
                    if (it.isNotEmpty()) {
                        executions.value = it.toInt()
                    } else {
                        executions.value = 0
                    }
                    exerciseChanged()
                }
            )
            TextField(
                value = imageUrl.value,
                modifier = Modifier.padding(16.dp),
                label = { Text(text = "Bild-URL") },
                onValueChange = {
                    imageUrl.value = it
                    exerciseChanged()
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddExerciseItemPreview() {
    AddExerciseItem(testWorkout.exercises[0], {})
}