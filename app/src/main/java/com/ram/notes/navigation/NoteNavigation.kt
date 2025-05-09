package com.ram.notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ram.notes.database.entity.Note
import com.ram.notes.viewModels.NoteViewModel
import com.ram.notes.views.AddEditNoteScreen
import com.ram.notes.views.HomeScreen

/**
 * @author ASUS
 * @date 14-04-2025
 */
@Composable
fun NoteNavigation(viewModel: NoteViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(viewModel = viewModel, onAddEditNote = { note ->
                navController.currentBackStackEntry?.savedStateHandle?.set("note", note)
                navController.navigate(Screen.AddEditNote.route)
            })
        }
        composable(Screen.AddEditNote.route) {
            val note = navController.previousBackStackEntry?.savedStateHandle?.get<Note?>("note")
            AddEditNoteScreen(
                viewModel = viewModel,
                existingNote = note,
                onDone = { navController.popBackStack() }
            )
        }
    }
}