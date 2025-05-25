@file:OptIn(ExperimentalMaterial3Api::class)

package com.ram.notes.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ram.notes.data.database.entity.Note
import com.ram.notes.ui.components.AppTopBar
import com.ram.notes.ui.theme.NotesComposeTheme
import com.ram.notes.viewModels.NoteViewModel

/**
 * @author ASUS
 * @date 14-04-2025
 */
@Composable
fun HomeScreen(viewModel: NoteViewModel, onAddEditNote: (Note?) -> Unit) {
    val notes by viewModel.notes.observeAsState(emptyList())

    Scaffold(containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            AppTopBar("Notes-Compose")
        },
        floatingActionButton = {
            FloatingActionButton (onClick = { onAddEditNote(null) },
                containerColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(20.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Note", tint = MaterialTheme.colorScheme.onPrimary)
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
