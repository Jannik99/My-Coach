package de.fjure.isd.mycoach.feature_workout.domain.use_case

import de.fjure.isd.mycoach.feature_workout.domain.model.Workout
import de.fjure.isd.mycoach.feature_workout.domain.repository.WorkoutRepository
import de.fjure.isd.mycoach.feature_workout.domain.util.OrderType
import de.fjure.isd.mycoach.feature_workout.domain.util.WorkoutOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetWorkoutsUseCase(private val repository: WorkoutRepository) {

    operator fun invoke(workoutOrder: WorkoutOrder = WorkoutOrder.ID(OrderType.Descending)): Flow<List<Workout>> {
        return repository.getWorkouts().map { workouts ->
            when(workoutOrder.orderType) {
                is OrderType.Ascending -> {
                    when (workoutOrder) {
                        is WorkoutOrder.ID -> workouts.sortedBy { it.id }
                        is WorkoutOrder.LastWorkedOut -> workouts.sortedBy { it.lastWorkedOut }
                    }
                }
                is OrderType.Descending -> {
                    when (workoutOrder) {
                        is WorkoutOrder.ID -> workouts.sortedByDescending { it.id }
                        is WorkoutOrder.LastWorkedOut -> workouts.sortedByDescending { it.lastWorkedOut }
                    }
                }
            }
        }
    }
}