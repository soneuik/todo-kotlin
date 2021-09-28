package com.sunsoft.todo_jetpack.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sunsoft.todo_jetpack.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao
}