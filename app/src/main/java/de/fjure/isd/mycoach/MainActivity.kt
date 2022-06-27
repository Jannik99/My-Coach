package de.fjure.isd.mycoach

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import de.fjure.isd.mycoach.commons.presentation.components.BottomNavigation
import de.fjure.isd.mycoach.commons.presentation.components.NavigationGraph
import de.fjure.isd.mycoach.feature_workout.presentation.workouts.components.WorkoutItem
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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