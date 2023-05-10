package com.example.todoapp.navigation.destinations

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.ui.screens.task.TaskScreen
import com.example.todoapp.ui.viewmodels.SharedViewModel
import com.example.todoapp.util.Action
import com.example.todoapp.util.Constants

private val namedNavArguments = listOf(navArgument(name = Constants.Navigation.TASK_ARGUMENT_KEY) {
    type = NavType.IntType
})

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.Navigation.TASK_SCREEN,
        arguments = listOf(navArgument(name = Constants.Navigation.TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments?.getInt(Constants.Navigation.TASK_ARGUMENT_KEY)
        taskId?.let { taskId -> sharedViewModel.getSelectedTask(taskId = taskId) }
        val selectedTask by sharedViewModel.selectedTask.collectAsStateWithLifecycle()

        TaskScreen(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}