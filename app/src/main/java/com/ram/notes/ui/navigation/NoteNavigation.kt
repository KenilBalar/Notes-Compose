package com.ram.notes.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ram.notes.data.database.entity.Note
import com.ram.notes.viewModels.NoteViewModel
import com.ram.notes.ui.screens.AddEditNoteScreen
import com.ram.notes.ui.screens.HomeScreen

/**
 * @author ASUS
 * @date 14-04-2025
 */
@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun NoteNavigation(viewModel: NoteViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            AnimatedContent(targetState = Screen.Home.route) { _ ->
                HomeScreen(viewModel = viewModel, onAddEditNote = { note ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("note", note)
                    navController.navigate(Screen.AddEditNote.route)
                })
            }
        }
        composable(Screen.AddEditNote.route) {
            val note = navController.previousBackStackEntry?.savedStateHandle?.get<Note?>("note")
            AnimatedContent(targetState = Screen.AddEditNote.route) { _ ->
                AddEditNoteScreen(
                    viewModel = viewModel,
                    existingNote = note,
                    onDone = { navController.popBackStack() }
                )
            }
        }
    }
}