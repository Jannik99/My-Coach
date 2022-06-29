package de.fjure.isd.mycoach

import android.content.res.AssetManager
import androidx.compose.runtime.*
import com.google.gson.Gson
import de.fjure.isd.mycoach.feature_workout.model.Exercise
import de.fjure.isd.mycoach.feature_workout.model.User
import de.fjure.isd.mycoach.feature_workout.model.Workout

var testWorkout: Workout = Workout(
    id = "1",
    name = "Test",
    description = "Test",
    imageUrl = "www.colorbook.io/imagecreator.php?hex=1168A6&width=1920&height=1080&text=Hello",
    playlistUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
    featured = true,
    category = "Test",
    exercises = listOf(
        Exercise(
            id = "1",
            name = "Test",
            description = "Test",
            imageUrl = "www.colorbook.io/imagecreator.php?hex=1168A6&width=1920&height=1080&text=Hello",
            executions = 2,
        )
    )
)

class DataController {

    fun writeWorkouts(workouts: List<Workout>) {
        // TODO
    }

    fun readUsers(assets: AssetManager): List<User> {
        return Gson().fromJson(assets.readAssetsFile("Users.json"), Array<User>::class.java)
            .toList()
    }

    fun readWorkouts(assets: AssetManager): List<Workout> {
        return Gson().fromJson(assets.readAssetsFile("Workouts.json"), Array<Workout>::class.java)
            .toList()
    }

    private fun AssetManager.readAssetsFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }
}
