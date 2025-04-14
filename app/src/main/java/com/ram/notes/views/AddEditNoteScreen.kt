package com.ram.notes.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ram.notes.database.entity.Note
import com.ram.notes.viewModels.NoteViewModel

/**
 * @author ASUS
 * @date 14-04-2025
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(viewModel: NoteViewModel, existingNote: Note?, onDone: () -> Unit) {
    var title by remember { mutableStateOf(existingNote?.title ?: "") }
    var content by remember { mutableStateOf(existingNote?.content ?: "") }
    var color by remember { mutableStateOf(existingNote?.color ?: "Blue") }
    val colorOptions = listOf("Red", "Green", "Blue", "Yellow", "Purple")

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(if (existingNote != null) "Edit Note" else "Add Note") })
        },
        content = { padding ->
            Column (modifier = Modifier.padding(padding).padding(16.dp)) {
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

                Row (modifier = Modifier.fillMaxWidth()) {
                    colorOptions.forEach { colorOption ->
                        Box(
                            modifier = Modifier
                                .padding(end = 8.dp, top = 14.dp)
                                .size(36.dp)
                                .background(
                                    color = when (colorOption) {
                                        "Red" -> Color(0xFFFFCDD2)
                                        "Green" -> Color(0xFFC8E6C9)
                                        "Blue" -> Color(0xFFBBDEFB)
                                        "Yellow" -> Color(0xFFFFF9C4)
                                        "Purple" -> Color(0xFFF0B6FF)
                                        else -> Color.LightGray
                                    },
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable { color = colorOption }
                                .border(
                                    width = if (color == colorOption) 2.dp else 1.dp,
                                    color = if (color == colorOption) Color.Gray else Color.LightGray,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton (onClick = onDone) { Text("Cancel") }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        if (title.isNotBlank() && content.isNotBlank()) {
                            if (existingNote != null) {
                                viewModel.updateNote(existingNote.copy(title = title, content = content, color = color))
                            } else {
                                viewModel.addNote(title, content, color)
                            }
                            onDone()
                        }
                    }) {
                        Text(if (existingNote != null) "Update Note" else "Add Note")
                    }
                }
            }
        }
    )
}