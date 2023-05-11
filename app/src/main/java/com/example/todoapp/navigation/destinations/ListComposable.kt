package com.example.todoapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.ui.screens.list.ListScreen
import com.example.todoapp.ui.viewmodels.SharedViewModel
import com.example.todoapp.util.Constants

fun NavGraphBuilder.listComposable(
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    composable(
        route = Constants.Navigation.LIST_SCREEN,
        arguments = listOf(
            navArgument(
                name = Constants.Navigation.LIST_ARGUMENT_KEY,
                builder = { type = NavType.StringType }
            )
        )
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}