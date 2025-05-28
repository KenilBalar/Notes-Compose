package com.ram.notes.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.ram.notes.data.database.entity.Note
import com.ram.notes.ui.components.AppTopBar
import com.ram.notes.ui.screens.NoteItem

/**
 * @author ASUS
 * @date 28-05-2025
 */
@Composable
fun HomeUI(
    notes: List<Note>,
    onAddNoteClick: () -> Unit = {},
    onDeleteNoteClick: (Note) -> Unit = {},
    onEditNoteClick: (Note) -> Unit = {}
) {
    Scaffold(containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            AppTopBar("Notes-Compose")
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddNoteClick() },
                containerColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add Note",
                        modifier = Modifier.padding(end = 4.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Text("Add note", fontWeight = FontWeight.Bold)
                }
            }
        }
    ) { padding ->
        if (notes.isEmpty()) {
//            LocalContext.current.toast("No notes found!")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "You have not added any notes yet!\nClick \"+ Add note\" button to create your first note :)",
                    color = MaterialTheme.colorScheme.primary.copy(0.6f),
                    fontSize = TextUnit(14f, TextUnitType.Sp)
                )
            }
        } else {
            LazyColumn(contentPadding = padding) {
                items(notes) { note ->
                    NoteItem(
                        note = note,
                        onEdit = { onEditNoteClick(it) },
                        onDelete = { onDeleteNoteClick(it) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    val notes = listOf(
        Note(0, "Fruits to buy", "1) Banana\n2) Apple\n3) Papaya\n4) Grapes\n5) Mango", "Yellow"),
        Note(1, "Rent", "Last date to pay rent 25th June 2025", "Red")
    )
    HomeUI(notes)
}