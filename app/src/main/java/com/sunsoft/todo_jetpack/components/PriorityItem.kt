package com.sunsoft.todo_jetpack.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sunsoft.todo_jetpack.data.models.Priority
import com.sunsoft.todo_jetpack.ui.theme.Typography

@Composable
fun PriorityItem(priority: Priority){
    Row(
        verticalAlignment= Alignment.CenterVertically
    ){
        Canvas(modifier = Modifier.size(16.dp)){
            drawCircle(color = priority.color)
        }
        Text(
            text = priority.name,
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }

}


@Composable
@Preview
fun PriorityItemPriview(){
    PriorityItem(priority =  Priority.LOW)
}