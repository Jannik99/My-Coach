package de.fjure.isd.mycoach.feature_workout.presentation.add_edit_workout.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fjure.isd.mycoach.commons.presentation.components.GenericButton
import de.fjure.isd.mycoach.commons.presentation.components.GenericTextField
import de.fjure.isd.mycoach.ui.theme.Blue
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import de.fjure.isd.mycoach.ui.theme.Red

@Composable
fun FinalizeWorkout() {
    MyCoachTheme {
        Column(
            modifier = Modifier
                .width(350.dp)
                .fillMaxHeight()
                .background(DarkGrey)
                .wrapContentSize(Alignment.TopCenter)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            GenericTextField(label = "Workoutname", value = "", onValueChange = {/*TODO*/ })
            Spacer(modifier = Modifier.height(25.dp))
            GenericTextField(label = "Playlistlink", value = "", onValueChange = {/*TODO*/ })
            Spacer(modifier = Modifier.height(25.dp))
            GenericTextField(label = "Kategorie", value = "", onValueChange = {/*TODO*/ })
            Spacer(modifier = Modifier.height(25.dp))
            GenericTextField(label = "Link Titelbild", value = "", onValueChange = {/*TODO*/ })
            Spacer(modifier = Modifier.height(25.dp))
            Text("Bild einfügem (ToDo)") // TODO: Bild einfügen
            Spacer(modifier = Modifier.height(25.dp))
            GenericButton(color = Red, text = "Workout bearbeiten", onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(25.dp))
            GenericButton(color = Blue, text = "Workout veröffentlichen", onClick = { /*TODO*/ })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FinalizeWorkoutPreview() {
    MyCoachTheme {
        FinalizeWorkout()
    }
}