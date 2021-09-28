package com.sunsoft.todo_jetpack.di

import android.content.Context
import androidx.room.Room
import com.sunsoft.todo_jetpack.data.ToDoDatabase
import com.sunsoft.todo_jetpack.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//Set up Dagger hilt in the project

//Annotations
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton //only one instance
    @Provides
    fun provideDatabase(
       @ApplicationContext context: Context
    )= Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase) = database.toDoDao()

}