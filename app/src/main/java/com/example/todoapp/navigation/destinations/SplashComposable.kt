package com.example.todoapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.ui.screens.list.ListScreen
import com.example.todoapp.ui.screens.splash.SplashScreen
import com.example.todoapp.ui.viewmodels.SharedViewModel
import com.example.todoapp.util.Constants

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = Constants.Navigation.SPLASH_SCREEN
    ) {
        SplashScreen()
    }
}