package com.sunsoft.todo_jetpack.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.sunsoft.todo_jetpack.util.Action
import com.sunsoft.todo_jetpack.util.Constants
import com.sunsoft.todo_jetpack.util.Constants.TASK_SCREEN


fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments =  listOf(navArgument(Constants.TASK_AGRUMENT_KEY){
            type = NavType.IntType
        })
    ){

    }
}