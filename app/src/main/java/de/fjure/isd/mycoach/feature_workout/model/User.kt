package de.fjure.isd.mycoach.feature_workout.model

class User(
    id: String,
    username: String,
    firstname: String,
    lastname: String,
    birthdate: String,
    createdWorkouts: List<String>?,
    weight: Double,
    height: Double,
    motto: String,
    profileImage: String,
) {
}