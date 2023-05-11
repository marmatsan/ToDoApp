package com.example.todoapp.ui.screens.task

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.todoapp.data.ToDoTask
import com.example.todoapp.data.models.Priority
import com.example.todoapp.ui.viewmodels.SharedViewModel
import com.example.todoapp.util.Action

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title.collectAsStateWithLifecycle()
    val description: String by sharedViewModel.description.collectAsStateWithLifecycle()
    val priority: Priority by sharedViewModel.priority.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        }
    ) { paddingValues ->
        TaskContent(
            title = title,
            paddingValues = paddingValues,
            onTitleChange = { newTitle -> sharedViewModel.updateTitle(newTitle) },
            description = description,
            onDescriptionChange = { newDescription ->
                sharedViewModel.updateDescription(
                    newDescription
                )
            },
            priority = priority,
            onPrioritySelected = { newPriority -> sharedViewModel.updatePriority(newPriority) }
        )
    }
}