package de.fjure.isd.mycoach.feature_workout.domain.repository

import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.model.WorkoutCategory
import kotlinx.coroutines.flow.Flow

interface WorkoutRepository {

    fun getWorkouts(): Flow<List<Workout>>

    suspend fun getWorkoutById(id: Int): Workout?

    suspend fun getWorkoutByCategory(category: WorkoutCategory): Workout?

    suspend fun insertWorkout(workout: Workout)

    suspend fun deleteWorkout(workout: Workout)
}