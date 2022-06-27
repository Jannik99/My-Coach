package de.fjure.isd.mycoach.commons.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon: ImageVector, var screen_route:String){

    object Home : BottomNavItem("Dashboard", Icons.Rounded.TrackChanges,"home")
    object Workouts : BottomNavItem("Workouts", Icons.Rounded.PlayCircleOutline,"workouts")
    object AddWorkout : BottomNavItem("Workout erstellen", Icons.Rounded.AddCircleOutline,"add_workout")
    object Community : BottomNavItem("Community", Icons.Rounded.Share,"community")
}