package com.sunsoft.todo_jetpack.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)



val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFFB3B2B1)
val DarkGray = Color(0xFF3C3C3C)

val lowPriorityColor = Color(0xFF8BC34A)
val MediumPriorityColor = Color(0xFFFFEB3B)
val HighPriorityColor = Color(0xFFFF5722)
val NonePriorityColor = Color(0xFFFFFFFF)


val Colors.fabBackgroundColor: Color
    @Composable
    get() = if(isLight) Teal200 else Color.LightGray


val Colors.topAppBarContentColor: Color
@Composable
get() = if(isLight) Color.White else Color.LightGray

val Colors.topAppBarBackgroundColor: Color
@Composable
get() = if (isLight) Purple500 else Color.Black