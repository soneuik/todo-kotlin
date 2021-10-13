package com.sunsoft.todo_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sunsoft.todo_jetpack.navigation.SetupNavigation
import com.sunsoft.todo_jetpack.ui.theme.TodojetpackTheme
import com.sunsoft.todo_jetpack.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private  lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()
            
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodojetpackTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController,
                sharedViewModel = sharedViewModel
                )

            }
        }
    }
}

