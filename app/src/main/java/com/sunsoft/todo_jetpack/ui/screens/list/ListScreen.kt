package com.sunsoft.todo_jetpack.ui.screens

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sunsoft.todo_jetpack.R
import com.sunsoft.todo_jetpack.ui.screens.list.ListAppBar
import com.sunsoft.todo_jetpack.ui.theme.fabBackgroundColor

@Composable
fun ListScreen(
    navigationToTaskScreen: (taskId:Int) -> Unit
){
    Scaffold(
        topBar = {
            ListAppBar()
        } ,
        content = {},
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


@Composable
@Preview
private fun ListScreenPreview(){
    ListScreen(navigationToTaskScreen = {})
}
