package com.example.todoapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.util.Action
import com.example.todoapp.util.Constants

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.Navigation.TASK_SCREEN,
        arguments = listOf(navArgument(name = Constants.Navigation.TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}