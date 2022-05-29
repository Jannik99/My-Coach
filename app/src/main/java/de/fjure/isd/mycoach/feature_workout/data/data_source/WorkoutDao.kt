package de.fjure.isd.mycoach.feature_workout.data.data_source

import androidx.room.*
import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Query("SELECT * FROM workout")
    fun getWorkouts(): Flow<List<Workout>>

    @Query("SELECT * FROM workout WHERE id = :id")
    suspend fun getWorkoutById(id: Int): Workout?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: Workout)

    @Delete
    suspend fun deleteWorkout(workout: Workout)
}