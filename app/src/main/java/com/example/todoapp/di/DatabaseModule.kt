package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.ToDoDao
import com.example.todoapp.data.ToDoDatabase
import com.example.todoapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ToDoDatabase = Room.databaseBuilder(
        context = context,
        klass = ToDoDatabase::class.java,
        name = Constants.Room.DATABASE_TABLE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase): ToDoDao = database.toDoDao()
}