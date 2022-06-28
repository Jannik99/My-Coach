package de.fjure.isd.mycoach.feature_workout.model

class Workout(
    val id: String,
    var name: String,
    val description: String,
    var exercises: List<Exercise>,
    var playlistUrl: String,
    var imageUrl: String,
    val featured: Boolean,
    var category: String,
) {
}
