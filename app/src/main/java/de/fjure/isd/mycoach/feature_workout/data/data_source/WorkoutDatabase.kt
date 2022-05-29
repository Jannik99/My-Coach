package de.fjure.isd.mycoach.feature_workout.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import de.fjure.isd.mycoach.feature_workout.domain.model.Workout

@Database(
    version = 1,
    entities = [Workout::class]
)
abstract class WorkoutDatabase: RoomDatabase() {

    abstract val workoutDao: WorkoutDao
}