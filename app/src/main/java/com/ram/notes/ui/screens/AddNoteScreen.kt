package com.ram.notes.ui.screens

import androidx.compose.runtime.Composable
import com.ram.notes.ui.layout.AddNoteUI
import com.ram.notes.viewModels.NoteViewModel

/**
 * @author ASUS
 * @date 14-04-2025
 */

@Composable
fun AddNoteScreen(
    viewModel: NoteViewModel,
    onDone: () -> Unit
) {

    AddNoteUI(
        onAdd = { note -> onDone(); viewModel.addNote(note.title, note.content, note.color) },
        onCancel = { onDone() })

}