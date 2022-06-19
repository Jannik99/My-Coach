package de.fjure.isd.mycoach.feature_workout.domain.model

sealed class WorkoutCategory {
    object SummerBody: WorkoutCategory()
    object BuildMuscle: WorkoutCategory()
    object Popular: WorkoutCategory()
}
