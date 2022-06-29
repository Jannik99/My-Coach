package de.fjure.isd.mycoach

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import de.fjure.isd.mycoach.commons.presentation.components.BottomNavigation
import de.fjure.isd.mycoach.commons.presentation.components.NavigationGraph
import de.fjure.isd.mycoach.feature_workout.model.User
import de.fjure.isd.mycoach.feature_workout.model.Workout
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme

var users = listOf<User>()
var workouts = listOf<Workout>()
var featuredWorkouts = listOf<Workout>()
var categories = listOf<String>()

class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setData()
        setContent {
            MyCoachTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigation(navController = navController) }
                ) {
                    NavigationGraph(navController = navController)
                }

            }
        }
    }

    fun setData() {
        users = DataController().readUsers(this.assets)
        workouts = DataController().readWorkouts(this.assets)
        featuredWorkouts = workouts.filter { it.featured }
        categories = workouts.map { it.category }.distinct().sorted()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCoachTheme {

    }
}
