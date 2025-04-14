@file:OptIn(ExperimentalMaterial3Api::class)

package com.ram.notes.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.ram.notes.database.entity.Note
import com.ram.notes.viewModels.NoteViewModel

/**
 * @author ASUS
 * @date 14-04-2025
 */
@Composable
fun HomeScreen(viewModel: NoteViewModel, onAddEditNote: (Note?) -> Unit) {
    val notes by viewModel.notes.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notes-Compose") },
//                actions = {
//                    IconButton(onClick = { /* Handle theme toggle */ }) {
//                        Icon(Icons.Default.Star, contentDescription = "Toggle Theme")
//                    }
//                }
            )
        },
        floatingActionButton = {
            FloatingActionButton (onClick = { onAddEditNote(null) }) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(notes) { note ->
                NoteItem(note = note, onEdit = { onAddEditNote(it) }, onDelete = { viewModel.deleteNote(it) })
            }
        }
    }
}