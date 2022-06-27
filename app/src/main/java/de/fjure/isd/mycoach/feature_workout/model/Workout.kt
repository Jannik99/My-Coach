package de.fjure.isd.mycoach.feature_workout.model

class Workout(
    val id: String,
    val name: String,
    val description: String,
    val exercises: List<Exercise>,
    val playlistUrl: String,
    val imageUrl: String,
    val featured: Boolean,
    val category: String,
) {
}
