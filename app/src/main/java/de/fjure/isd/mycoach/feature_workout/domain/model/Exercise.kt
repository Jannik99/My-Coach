package de.fjure.isd.mycoach.feature_workout.domain.model

class Exercise(
    val id: String,
    var name: String,
    var description: String,
    var imageUrl: String,
    var executions: Int,
) {
}