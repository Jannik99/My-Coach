package de.fjure.isd.mycoach.feature_workout.domain.use_case

import de.fjure.isd.mycoach.feature_workout.domain.model.Workout

data class WorkoutUseCases(
    val getWorkouts: GetWorkoutsUseCase,
    val deleteWorkoutUseCase: DeleteWorkoutUseCase,
    val addWorkoutUseCase: AddWorkoutUseCase
)
