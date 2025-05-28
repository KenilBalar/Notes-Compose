package com.ram.notes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ram.notes.data.database.entity.Note
import com.ram.notes.viewModels.NoteViewModel
import com.ram.notes.ui.screens.AddNoteScreen
import com.ram.notes.ui.screens.HomeScreen

/**
 * @author ASUS
 * @date 14-04-2025
 */
@Composable
fun NoteNavigation(viewModel: NoteViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route,) {
            HomeScreen(viewModel = viewModel, onAddNoteClick = {
                navController.navigate(Screen.AddNote.route)
            })
        }
        composable(Screen.AddNote.route) {
            AddNoteScreen(
                viewModel = viewModel,
                onDone = { navController.popBackStack() }
            )
        }
    }
}