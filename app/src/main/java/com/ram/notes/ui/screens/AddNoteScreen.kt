package com.ram.notes.ui.screens

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ram.notes.ui.components.AppButton
import com.ram.notes.ui.components.AppTopBar
import com.ram.notes.ui.components.RoundedTextField
import com.ram.notes.utils.getColorFromName
import com.ram.notes.utils.toast
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
    var title by rememberSaveable { mutableStateOf("") }
    var content by rememberSaveable { mutableStateOf("") }
    var color by rememberSaveable { mutableStateOf("Blue") }
    val context = LocalContext.current
    val colorOptions = listOf("Red", "Green", "Blue", "Yellow", "Purple")

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            AppTopBar("Add Note")
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {
                RoundedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = "Title"
                )
                Spacer(modifier = Modifier.height(8.dp))
                RoundedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = "Content"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Color Picker
                Row(modifier = Modifier.fillMaxWidth()) {
                    colorOptions.forEach { name ->
                        Box(
                            modifier = Modifier
                                .padding(end = 8.dp, top = 14.dp)
                                .size(44.dp)
                                .background(
                                    color = getColorFromName(name),
                                    shape = CircleShape
                                )
                                .clickable { color = name }
                                .border(
                                    width = if (color == name) 3.dp else 3.dp,
                                    color = if (color == name) getColorFromName(name) else MaterialTheme.colorScheme.background,
                                    shape = CircleShape
                                )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    AppButton(text = "Cancel", isPositive = false, onClick = onDone)
                    Spacer(modifier = Modifier.width(16.dp))
                    AppButton(text = "Add Note", isPositive = true, onClick = {
                        if (title.isBlank()) {
                            context.toast("Title cannot be empty")
                        } else {
                            viewModel.addNote(title, content, color)
                            onDone()
                        }
                    })
                }
            }
        }
    )
}

