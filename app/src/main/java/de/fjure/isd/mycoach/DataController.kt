package de.fjure.isd.mycoach

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import de.fjure.isd.mycoach.feature_workout.model.Exercise
import de.fjure.isd.mycoach.feature_workout.model.User
import de.fjure.isd.mycoach.feature_workout.model.Workout
import java.io.InputStream

private var gson = Gson()
var workouts: List<Workout> = listOf()
var featuredWorkouts: List<Workout> = listOf()
var users: List<User> = listOf()
var user: User? = null

var testWorkout: Workout = Workout(
    id = "1",
    name = "Test",
    description = "Test",
    imageUrl = "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60",
    playlistUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
    featured = true,
    category = "Test",
    exercises = listOf(
        Exercise(
            id = "1",
            name = "Test",
            description = "Test",
            imageUrl = "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60",
            executions = 2,
        )
    )
)

@Composable
fun setData() {
    setUsers()
    setWorkouts()
}

@Composable
private fun setUsers() {
    val json = ReadDataFile("Users.json")
    val users = gson.fromJson<List>(json, User::class.java)
    user = users[0]
}

@Composable
private fun setWorkouts() {
    val json = ReadDataFile("Workouts.json")
    workouts = gson.fromJson(json, Array<Workout>::class.java).toList()
    featuredWorkouts = workouts.filter { it.featured }
}


@Composable
fun ReadDataFile(filename: String): String {
    var dataText by remember {
        mutableStateOf("asd")
    }

    val context = LocalContext.current
    LaunchedEffect(true) {
        kotlin.runCatching {
            val inputStream: InputStream = context.assets.open(filename)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            String(buffer)
        }.onSuccess {
            dataText = it
        }.onFailure {
            dataText = it.message ?: "Error"
        }

    }
    return dataText
}