package de.fjure.isd.mycoach.commons.presentation.components

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import de.fjure.isd.mycoach.feature_workout.presentation.add_edit_workout.AddWorkout
import de.fjure.isd.mycoach.feature_workout.presentation.community.Community
import de.fjure.isd.mycoach.feature_workout.presentation.dashboard.HomeScreen
import de.fjure.isd.mycoach.feature_workout.presentation.workout_details.WorkoutDetails
import de.fjure.isd.mycoach.feature_workout.presentation.workouts.Workouts
import de.fjure.isd.mycoach.ui.theme.Coral
import de.fjure.isd.mycoach.ui.theme.Grey
import de.fjure.isd.mycoach.ui.theme.Ivory
import de.fjure.isd.mycoach.workouts

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Workouts,
        BottomNavItem.AddWorkout,
        BottomNavItem.Community,
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = Grey,
        contentColor = Ivory,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(icon = {
                Icon(
                    item.icon,
                    contentDescription = item.title
                )
            },
                selectedContentColor = Coral,
                unselectedContentColor = Ivory,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }

}


// ToDo: Remove the Popups and use the NavController.navigate() function instead. Currently only for development purposes.
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Workouts.screen_route) {
            Workouts()
        }
        composable(BottomNavItem.AddWorkout.screen_route) {
            AddWorkout()
        }
        composable(BottomNavItem.Community.screen_route) {
            Community()
        }
        composable(
            "WorkoutDetails?workoutID={workoutID}",
            arguments = listOf(navArgument("workoutID") { type = NavType.StringType })
        ) {
            val workoutID = it.arguments?.getString("workoutID")
            val workout = workouts.filter { it.id == workoutID }.first()
            WorkoutDetails(
                workout = workout,
                onDismiss = {
                    navController.popBackStack()
                }, onStartWorkout = {
                    // ToDo: Start workout
                }
            )
        }
    }
}