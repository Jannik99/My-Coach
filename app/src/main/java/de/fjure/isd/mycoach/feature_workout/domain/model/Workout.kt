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
    val imageURL: String,
    val playList: String?,
    //val Exercises: Optional<Array<Exercise>>,

    @PrimaryKey
    val id: Int? = null,
) {
}

enum class WorkoutCategory {
    SummerBody,
    Popular
}

class InvalidWorkoutException(message: String) : Exception(message)
