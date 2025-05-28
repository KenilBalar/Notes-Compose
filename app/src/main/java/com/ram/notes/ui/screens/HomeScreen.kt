package com.ram.notes.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.ram.notes.data.database.entity.Note
import com.ram.notes.ui.layout.BottomSheetUI
import com.ram.notes.ui.layout.HomeUI
import com.ram.notes.ui.theme.getSurfaceColor
import com.ram.notes.viewModels.NoteViewModel

/**
 * @author ASUS
 * @date 14-04-2025
 */
@Composable
fun HomeScreen(viewModel: NoteViewModel, onAddNoteClick: () -> Unit) {
    val notes by viewModel.notes.observeAsState(emptyList())
    var editingNote by remember { mutableStateOf<Note?>(null) }

    HomeUI(
        notes = notes,
        onAddNoteClick = { onAddNoteClick() },
        onDeleteNoteClick = { viewModel.deleteNote(it) },
        onEditNoteClick = { editingNote = it }
    )

    editingNote?.let {
        EditNoteBottomSheet(note = it, viewModel = viewModel) {
            editingNote = null
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteBottomSheet(
    note: Note,
    viewModel: NoteViewModel,
    onDismiss: () -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = bottomSheetState,
        containerColor = getSurfaceColor(),
    ) {

        BottomSheetUI(note, onUpdate = { note ->
            viewModel.updateNote(note)
        }, onDismiss)

    }
}
