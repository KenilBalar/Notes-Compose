package com.ram.notes.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ram.notes.database.entity.Note
import com.ram.notes.viewModels.NoteViewModel

/**
 * @author ASUS
 * @date 12-04-2025
 */
@Composable
fun NoteApp(viewModel: NoteViewModel) {
    val notes by viewModel.notes.observeAsState(emptyList())
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    var showAddNote by remember { mutableStateOf(false) }
    var editingNote by remember { mutableStateOf<Note?>(null) }

    val colorOptions = listOf("Red", "Green", "Blue", "Yellow", "Purple")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            if (showAddNote) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Content") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    colorOptions.forEach { colorOption ->
                        Box(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(36.dp)
                                .background(
                                    color = when (colorOption) {
                                        "Red" -> Color.Red
                                        "Green" -> Color.Green
                                        "Blue" -> Color.Blue
                                        "Yellow" -> Color.Yellow
                                        "Purple" -> Color.Magenta
                                        else -> Color.Gray
                                    },
                                    shape = CircleShape
                                )
                                .clickable { color = colorOption }
                                .border(
                                    width = if (color == colorOption) 3.dp else 1.dp,
                                    color = if (color == colorOption) Color.Black else Color.LightGray,
                                    shape = CircleShape
                                )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        if (title.isNotBlank() && content.isNotBlank()) {
                            if (editingNote != null) {
                                viewModel.updateNote(editingNote!!.copy(title = title, content = content, color = color))
                            } else {
                                viewModel.addNote(title, content, color)
                            }
                            title = ""
                            content = ""
                            color = "Blue"
                            editingNote = null
                            showAddNote = false
                        }
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(if (editingNote != null) "Update Note" else "Add Note")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(notes) { note ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = when (note.color) {
                                "Red" -> Color(0xFFFFCDD2)
                                "Green" -> Color(0xFFC8E6C9)
                                "Blue" -> Color(0xFFBBDEFB)
                                "Yellow" -> Color(0xFFFFF9C4)
                                "Purple" -> Color(0xFFE1BEE7)
                                else -> Color.LightGray
                            }
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = note.title, fontWeight = FontWeight.Bold)
                                Text(text = note.content)
                            }
                            Row {
                                IconButton(onClick = {
                                    editingNote = note
                                    title = note.title
                                    content = note.content
                                    color = note.color
                                    showAddNote = true
                                }) {
                                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                                }
                                IconButton(onClick = { viewModel.deleteNote(note) }) {
                                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                                }
                            }
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                title = ""
                content = ""
                color = "Blue"
                editingNote = null
                showAddNote = !showAddNote
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Note")
        }
    }
}
