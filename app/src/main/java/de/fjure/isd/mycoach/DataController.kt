package de.fjure.isd.mycoach

import android.content.res.AssetManager
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import de.fjure.isd.mycoach.feature_workout.model.Exercise
import de.fjure.isd.mycoach.feature_workout.model.User
import de.fjure.isd.mycoach.feature_workout.model.Workout
import timber.log.Timber
import java.io.InputStream

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

class DataController {

    fun readUsers(assets: AssetManager): List<User> {
        return Gson().fromJson(assets.readAssetsFile("Users.json"), Array<User>::class.java).toList()
    }

    fun readWorkouts(assets: AssetManager): List<Workout> {
        return Gson().fromJson(assets.readAssetsFile("Workouts.json"), Array<Workout>::class.java).toList()
    }

    private fun AssetManager.readAssetsFile(fileName: String): String = open(fileName).bufferedReader().use{it.readText()}
}
