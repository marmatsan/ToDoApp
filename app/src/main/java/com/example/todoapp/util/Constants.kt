package com.example.todoapp.util

import androidx.compose.ui.unit.dp

object Constants {

    object Room {
        const val DATABASE_TABLE_NAME = "todo_table"
        const val DATABASE_NAME = "todo_database"
    }

    object Navigation {
        const val LIST_ARGUMENT_KEY = "action"
        const val TASK_ARGUMENT_KEY = "taskId"

        const val LIST_SCREEN = "list/{$LIST_ARGUMENT_KEY}"
        const val TASK_SCREEN = "task/´{$TASK_ARGUMENT_KEY}"
    }

    object Dimensions {
        val LARGE_PADDING = 12.dp
        val MEDIUM_PADDING = 8.dp
        val SMALL_PADDING = 6.dp

        val PRIORITY_INDICATOR_SIZE = 16.dp

        val TOPAPPBAR_HEIGHT = 56.dp
        val TASK_ITEM_ELEVATION = 2.dp
    }

    // Extension properties

    val String.Companion.Empty
        inline get() = ""
}