package de.fjure.isd.mycoach.feature_workout.model

class Exercise(
    val id: String,
    var name: String,
    var description: String,
    var imageUrl: String,
    var executions: Int,
) {
}