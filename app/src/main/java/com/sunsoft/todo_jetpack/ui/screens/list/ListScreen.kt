package com.sunsoft.todo_jetpack.ui.screens

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sunsoft.todo_jetpack.R
import com.sunsoft.todo_jetpack.ui.screens.list.ListAppBar
import com.sunsoft.todo_jetpack.ui.screens.list.ListContent
import com.sunsoft.todo_jetpack.ui.theme.fabBackgroundColor
import com.sunsoft.todo_jetpack.ui.viewmodels.SharedViewModel
import com.sunsoft.todo_jetpack.util.SearchAppBarState

@ExperimentalMaterialApi
@Composable
fun ListScreen(
    navigationToTaskScreen: (taskId:Int) -> Unit,
    sharedViewModel: SharedViewModel
){

    LaunchedEffect(key1 = true){
        //Log.d("ListScreen", "Launched Effect Triggered!")
        sharedViewModel.getAllTasks()
    }

    //collectAsState() will observe Flow from the composalbe function.
    val allTasks by sharedViewModel.allTasks.collectAsState()
    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        } ,
        content = {
                  ListContent(
                      tasks = allTasks,
                      navigateToTaskScreen = navigationToTaskScreen
                  )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigationToTaskScreen)
        },
    )
}


@Composable
fun ListFab(
    onFabClicked: (taskId:Int) -> Unit
){
    FloatingActionButton(onClick = {
        onFabClicked(-1)
    },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = stringResource(
                id = R.string.add_button
            ),
            tint= Color.White
        )
    }
}

