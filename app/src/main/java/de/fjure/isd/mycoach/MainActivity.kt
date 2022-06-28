package de.fjure.isd.mycoach

import android.annotation.SuppressLint
import android.content.res.AssetManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import de.fjure.isd.mycoach.commons.presentation.components.BottomNavigation
import de.fjure.isd.mycoach.commons.presentation.components.NavigationGraph
import de.fjure.isd.mycoach.feature_workout.model.User
import de.fjure.isd.mycoach.feature_workout.model.Workout
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme
import timber.log.Timber

var users = listOf<User>()
var workouts = listOf<Workout>()
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        users = DataController().readUsers(this.assets)
        Timber.d("User size: ${users.size}")

        workouts = DataController().readWorkouts(this.assets)
        Timber.d("Workouts size: ${workouts.size}")

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
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCoachTheme {
        Greeting("Android")
    }
}
