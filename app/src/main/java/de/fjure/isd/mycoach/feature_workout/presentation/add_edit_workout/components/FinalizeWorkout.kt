package de.fjure.isd.mycoach.feature_workout.presentation.add_edit_workout.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import de.fjure.isd.mycoach.commons.presentation.components.GenericButton
import de.fjure.isd.mycoach.commons.presentation.components.GenericTextField
import de.fjure.isd.mycoach.feature_workout.model.Exercise
import de.fjure.isd.mycoach.ui.theme.Blue
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Red

@Composable
fun FinalizeWorkout(onDismiss: () -> Unit, exercises: List<Exercise>) {

    var name = remember { mutableStateOf("") }
    var playlistUrl = remember { mutableStateOf("") }
    var imageUrl = remember { mutableStateOf("") }
    var category = remember { mutableStateOf("") }

    fun submit() {
        
        onDismiss()
    }

    MyCoachTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkGrey)
                .wrapContentSize(Alignment.TopCenter)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            GenericTextField(
                label = "Workoutname",
                value = name.value,
                onValueChange = { name.value = it })
            Spacer(modifier = Modifier.height(25.dp))
            GenericTextField(
                label = "Playlistlink",
                value = playlistUrl.value,
                onValueChange = { playlistUrl.value = it })
            Spacer(modifier = Modifier.height(25.dp))
            GenericTextField(
                label = "Kategorie",
                value = category.value,
                onValueChange = { category.value = it })
            Spacer(modifier = Modifier.height(25.dp))
            GenericTextField(
                label = "Link Titelbild",
                value = "",
                onValueChange = { imageUrl.value = it })
            Spacer(modifier = Modifier.height(25.dp))
            AsyncImage(
                model = imageUrl.value,
                contentDescription = "",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            GenericButton(
                color = Red,
                text = "Workout bearbeiten",
                onClick = { onDismiss() },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )
            Spacer(modifier = Modifier.height(25.dp))
            GenericButton(
                color = Blue,
                text = "Workout ver??ffentlichen",
                onClick = { submit() },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FinalizeWorkoutPreview() {
    MyCoachTheme {
        FinalizeWorkout(onDismiss = {}, exercises = listOf())
    }
}