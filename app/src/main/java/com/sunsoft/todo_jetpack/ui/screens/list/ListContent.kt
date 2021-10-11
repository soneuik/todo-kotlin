package com.sunsoft.todo_jetpack.ui.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.sunsoft.todo_jetpack.data.models.Priority
import com.sunsoft.todo_jetpack.data.models.ToDoTask
import com.sunsoft.todo_jetpack.ui.theme.*
import java.lang.reflect.Modifier


@Composable
fun ListContent(){

}

@ExperimentalMaterialApi
@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen:(taskId: Int) -> Unit
){
    Surface(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation =TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        }
    ){
        Column(
            modifier = androidx.compose.ui.Modifier
            .padding(all = LARGE_PADDING)
            .fillMaxWidth()
        ){
            Row{
                Text(
                    modifier = androidx.compose.ui.Modifier.weight(8f),
                    text = toDoTask.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .weight(1f),
                    contentAlignment = Alignment.TopEnd
                    ){
                    androidx.compose.foundation.Canvas(modifier = androidx.compose.ui.Modifier
                        .width(PRIORITY_INDICATOR_SIZE)
                        .height(PRIORITY_INDICATOR_SIZE)){
                        drawCircle(
                            color = toDoTask.priority.color
                        )
                    }
                }
            }
            Text(
                modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                text = toDoTask.description,
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@ExperimentalMaterialApi
@Composable
@Preview
fun TaskItemPrivew() {
    TaskItem(
        toDoTask = ToDoTask(
            id = 0,
            title = "Title",
            description = "Some random Text",
            priority = Priority.MEDIUM
        ),
        navigateToTaskScreen = {}
    )
}