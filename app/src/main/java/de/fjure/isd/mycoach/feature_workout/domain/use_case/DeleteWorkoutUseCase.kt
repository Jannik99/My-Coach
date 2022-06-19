package de.fjure.isd.mycoach.feature_workout.domain.use_case

import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.repository.WorkoutRepository

class DeleteWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(workout: Workout) {
        repository.deleteWorkout(workout)
    }
}