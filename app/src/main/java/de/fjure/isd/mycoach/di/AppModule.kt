package de.fjure.isd.mycoach.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.fjure.isd.mycoach.feature_workout.data.data_source.WorkoutDatabase
import de.fjure.isd.mycoach.feature_workout.data.repository.WorkoutRepositoryImpl
import de.fjure.isd.mycoach.feature_workout.domain.repository.WorkoutRepository
import de.fjure.isd.mycoach.feature_workout.domain.use_case.DeleteWorkoutUseCase
import de.fjure.isd.mycoach.feature_workout.domain.use_case.GetWorkoutsUseCase
import de.fjure.isd.mycoach.feature_workout.domain.use_case.WorkoutUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWorkoutDatabase(app: Application): WorkoutDatabase {
        return Room.databaseBuilder(
            app,
            WorkoutDatabase::class.java,
            WorkoutDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideWorkoutRepository(db: WorkoutDatabase): WorkoutRepository {
        return WorkoutRepositoryImpl(db.workoutDao)
    }

    @Provides
    @Singleton
    fun provideWorkoutUseCases(repository: WorkoutRepository): WorkoutUseCases {
        return WorkoutUseCases(
            getWorkouts = GetWorkoutsUseCase(repository),
            deleteWorkoutUseCase = DeleteWorkoutUseCase(repository)
        )
    }
}