package com.sunsoft.todo_jetpack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sunsoft.todo_jetpack.navigation.destinations.listComposable
import com.sunsoft.todo_jetpack.navigation.destinations.taskComposable
import com.sunsoft.todo_jetpack.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation (
    navController: NavHostController
){
    val screen = remember(navController){
        Screens(navController =  navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ){
        listComposable(
            navigationToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}
