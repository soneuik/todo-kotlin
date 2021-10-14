package com.sunsoft.todo_jetpack.ui.screens.task

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sunsoft.todo_jetpack.R
import com.sunsoft.todo_jetpack.ui.screens.list.ListAppBarActions
import com.sunsoft.todo_jetpack.ui.theme.topAppBarBackgroundColor
import com.sunsoft.todo_jetpack.ui.theme.topAppBarContentColor
import com.sunsoft.todo_jetpack.util.Action

@Composable
fun TaskAppBar(  navigateToListScreen: (Action) -> Unit){
    NewTaskAppBar(navigateToListScreen = navigateToListScreen)
}

@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
){
    TopAppBar(
        navigationIcon={
                       BackAction(onBackClicked = navigateToListScreen)
        },
        title={
            Text(
                text= "Add Task",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions ={
            AddAction(onAddClicked = navigateToListScreen)
        },
        backgroundColor= MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
){
    IconButton(onClick = { onBackClicked(Action.NO_ACTION)}) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Arrow",
            tint = MaterialTheme.colors.topAppBarContentColor

        )
    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
){
    IconButton(onClick = { onAddClicked(Action.ADD)}) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Add Task",
            tint = MaterialTheme.colors.topAppBarContentColor

        )
    }
}

@Composable
@Preview
fun NewTaskAppBarPreview(){
    NewTaskAppBar(navigateToListScreen = {})
}