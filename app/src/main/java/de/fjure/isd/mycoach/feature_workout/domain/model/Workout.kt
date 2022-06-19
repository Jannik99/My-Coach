package de.fjure.isd.mycoach.feature_workout.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workout(
    val name: String,
    val description: String,
    val category: WorkoutCategory,
    val createdAt: Long,
    val lastWorkedOut: Long,
    val picture: String,
    @PrimaryKey val id: Int? = null,
) {
    companion object {
        val placeholderImages = listOf<String>(
            "https://pixabay.com/de/photos/kettlebell-fitness-crossfit-fit-3293475/",
            "https://pixabay.com/de/photos/planke-fitness-muskulös-trainieren-1327256/",
            "https://pixabay.com/de/photos/frau-yoga-dehnen-meditation-2573216/"
        )
    }
}
