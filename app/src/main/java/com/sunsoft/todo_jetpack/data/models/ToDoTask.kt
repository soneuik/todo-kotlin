package com.sunsoft.todo_jetpack.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sunsoft.todo_jetpack.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority // I made the priority in models

)
