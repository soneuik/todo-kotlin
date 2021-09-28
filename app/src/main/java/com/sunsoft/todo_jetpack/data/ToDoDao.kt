package com.sunsoft.todo_jetpack.data

import androidx.room.*
import com.sunsoft.todo_jetpack.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow


//Data Access Object
@Dao
interface ToDoDao  {
    @Query(" SELECT * FROM todo_table Order by id asc")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query(" SELECT * FROM todo_table where id =:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    //Ignore or Replace 그냥 넣거나 같은게 있으면 대체하거나 설정.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("Delete From todo_table")
    suspend fun deleteAllTasks()

    @Query("Select * From todo_table where title Like:searchQuery Or description Like:searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query("Select * From todo_table Order by case when priority Like 'L%' Then 1 when priority Like 'M%' then 2 when priority like 'H%' then 3 End")
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("Select * From todo_table Order by case when priority Like 'L%' Then 1 when priority Like 'M%' then 2 when priority like 'H%' then 3 End")
    fun sortByHighPriority(): Flow<List<ToDoTask>>
}