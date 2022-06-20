package de.fjure.isd.mycoach.feature_workout.presentation.workouts

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.fjure.isd.mycoach.feature_workout.domain.use_case.WorkoutUseCases
import de.fjure.isd.mycoach.feature_workout.domain.util.OrderType
import de.fjure.isd.mycoach.feature_workout.domain.util.WorkoutOrder
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WorkoutsViewModel @Inject constructor(
    private val workoutUseCases: WorkoutUseCases
): ViewModel() {
    private val _state = mutableStateOf(WorkoutsState())
    val state: State<WorkoutsState> = _state

    private var getWorkoutsJob: Job? = null

    init {
        getWorkouts(WorkoutOrder.ID(OrderType.Descending))
    }

    private fun getWorkouts(workoutOrder: WorkoutOrder) {
        getWorkoutsJob?.cancel()
        getWorkoutsJob = workoutUseCases.getWorkouts(workoutOrder)
            .onEach { workouts ->
                _state.value = state.value.copy(workouts = workouts, workoutOrder = workoutOrder)
            }
            .launchIn(viewModelScope)
    }
}