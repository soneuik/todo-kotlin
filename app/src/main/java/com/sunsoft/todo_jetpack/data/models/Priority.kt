package com.sunsoft.todo_jetpack.data.models

import com.sunsoft.todo_jetpack.ui.theme.HighPriorityColor
import com.sunsoft.todo_jetpack.ui.theme.MediumPriorityColor
import com.sunsoft.todo_jetpack.ui.theme.NonePriorityColor
import com.sunsoft.todo_jetpack.ui.theme.lowPriorityColor

enum class Priority(val color: androidx.compose.ui.graphics.Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(lowPriorityColor),
    NONE(NonePriorityColor)
}