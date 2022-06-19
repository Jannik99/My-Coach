package de.fjure.isd.mycoach.feature_workout.data.repository

import de.fjure.isd.mycoach.feature_workout.data.data_source.WorkoutDao
import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.model.WorkoutCategory
import de.fjure.isd.mycoach.feature_workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow

class WorkoutRepositoryImpl(
    private val dao: WorkoutDao
) : WorkoutRepository {
    override fun getWorkouts(): Flow<List<Workout>> {
        return dao.getWorkouts()
    }

    override suspend fun getWorkoutById(id: Int): Workout? {
        return dao.getWorkoutById(id)
    }

    override suspend fun getWorkoutByCategory(category: WorkoutCategory): Workout? {
        return dao.getWorkoutByCategory(category)
    }

    override suspend fun insertWorkout(workout: Workout) {
        dao.insertWorkout(workout)
    }

    override suspend fun deleteWorkout(workout: Workout) {
        dao.deleteWorkout(workout)
    }
}