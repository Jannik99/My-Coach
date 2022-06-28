package de.fjure.isd.mycoach.json_data

import com.google.gson.Gson
import de.fjure.isd.mycoach.WorkoutApp
import de.fjure.isd.mycoach.feature_workout.model.Exercise
import de.fjure.isd.mycoach.feature_workout.model.User
import de.fjure.isd.mycoach.feature_workout.model.Workout


class JsonController {
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

    init {
        // getUsers()
        // getWorkouts()
        readJSONFile("Workouts.json")
    }

    private fun getUsers() {
        val json = readJSONFile("Users.json")
        users = getUsersFromJson(json)
        user = users[0]
    }


    private fun getUsersFromJson(json: String): List<User> {
        return gson.fromJson(json, Array<User>::class.java).toList()
    }

    private fun getWorkouts() {
        val json = readJSONFile("Workouts.json")
        workouts = getWorkoutData(json)
        featuredWorkouts = getFeaturedWorkouts(workouts)
    }

    private fun getFeaturedWorkouts(workouts: List<Workout>): List<Workout> {
        return workouts.filter { it.featured }
    }

    // get Workouts from JSON-String
    private fun getWorkoutData(json: String): List<Workout> {
        return gson.fromJson(json, Array<Workout>::class.java).toList()
    }

    // Gets the json data from the WorkoutData.json File and returns it as a string
    private fun readJSONFile(filename: String): String {
        print("Reading JSON File: $filename")
        //  WorkoutApp().assets.open(filename).use {
        //    return it.readBytes().toString(Charsets.UTF_8)
        // }
        var assetmanager = WorkoutApp().assets
        println(assetmanager.list("").toString())
        return ""
    }
}