package com.example.todoapp.navigation

import androidx.navigation.NavController
import com.example.todoapp.util.Action
import com.example.todoapp.util.Constants

class Screens(navController: NavController) {
    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION.name}") {
            popUpTo(Constants.Navigation.SPLASH_SCREEN) { inclusive = true }
        }
    }
    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(route = Constants.Navigation.LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}