package de.fjure.isd.mycoach.feature_workout.model

class User(
    val id: String,
    val username: String,
    val firstname: String,
    val lastname: String,
    val birthdate: String,
    val createdWorkouts: List<String>?,
    val weight: Double,
    val height: Double,
    val motto: String,
    val profileImage: String,
) {
}