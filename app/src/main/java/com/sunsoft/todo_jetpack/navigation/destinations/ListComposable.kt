package com.sunsoft.todo_jetpack.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.sunsoft.todo_jetpack.ui.screens.ListScreen
import com.sunsoft.todo_jetpack.util.Constants.LIST_ARGUMENT_KEY
import com.sunsoft.todo_jetpack.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigationToTaskScreen: (taskId: Int) -> Unit
){
    composable(
        route = LIST_SCREEN,
        arguments =  listOf(navArgument(LIST_ARGUMENT_KEY){
          type = NavType.StringType
        })
    ){
        ListScreen(navigationToTaskScreen = navigationToTaskScreen)
    }
}