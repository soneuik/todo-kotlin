package com.sunsoft.todo_jetpack.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sunsoft.todo_jetpack.navigation.destinations.listComposable
import com.sunsoft.todo_jetpack.navigation.destinations.taskComposable
import com.sunsoft.todo_jetpack.ui.viewmodels.SharedViewModel
import com.sunsoft.todo_jetpack.util.Constants.LIST_SCREEN

@ExperimentalMaterialApi
@Composable
fun SetupNavigation (
    navController: NavHostController,
    sharedViewModel: SharedViewModel
){
    val screen = remember(navController){
        Screens(navController =  navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ){
        listComposable(
            navigationToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}
