package de.fjure.isd.mycoach.feature_workout.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
