package de.fjure.isd.mycoach.feature_workout.presentation.workouts

import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.util.OrderType
import de.fjure.isd.mycoach.feature_workout.domain.util.WorkoutOrder

data class WorkoutsState(
    val workouts: List<Workout> = emptyList(),
    val workoutOrder: WorkoutOrder = WorkoutOrder.ID(OrderType.Descending)
)