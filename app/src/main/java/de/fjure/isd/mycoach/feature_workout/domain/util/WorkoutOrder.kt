package de.fjure.isd.mycoach.feature_workout.domain.util

sealed class WorkoutOrder(val orderType: OrderType) {
    class LastWorkedOut(orderType: OrderType): WorkoutOrder(orderType)
    class ID(orderType: OrderType): WorkoutOrder(orderType)
    //class Category(orderType: OrderType): WorkoutOrder(orderType)
}
