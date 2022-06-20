package de.fjure.isd.mycoach.feature_workout.domain.use_case

import de.fjure.isd.mycoach.feature_workout.domain.model.InvalidWorkoutException
import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.repository.WorkoutRepository

class AddWorkoutUseCase(private val repository: WorkoutRepository) {

    @Throws(InvalidWorkoutException::class)
    suspend operator fun invoke(workout: Workout) {
        if(workout.name.isBlank()) {
            throw InvalidWorkoutException("Workout Name darf nicht leer sein!")
        }
        if(workout.description.isBlank()) {
            throw InvalidWorkoutException("Workout Beschreibung darf nicht leer sein!")
        }
        repository.insertWorkout(workout)
    }
}