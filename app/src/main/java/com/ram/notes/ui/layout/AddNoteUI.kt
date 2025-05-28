package com.ram.notes.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ram.notes.data.database.entity.Note
import com.ram.notes.ui.components.AppButton
import com.ram.notes.ui.components.AppTopBar
import com.ram.notes.ui.components.CardView
import com.ram.notes.ui.components.ColorPickerUI
import com.ram.notes.ui.components.RoundedTextField
import com.ram.notes.ui.components.SpaceHorizontal
import com.ram.notes.ui.components.SpaceVertical
import com.ram.notes.ui.theme.getBackgroundColor
import com.ram.notes.utils.toast
import com.ram.notes.viewModels.NoteViewModel

/**
 * @author ASUS
 * @date 28-05-2025
 */
@Composable
fun AddNoteUI(
    onCancel : ()-> Unit = {},
    onAdd: (Note) -> Unit = {}
) {

    var title by rememberSaveable { mutableStateOf("") }
    var content by rememberSaveable { mutableStateOf("") }
    var color by rememberSaveable { mutableStateOf("Red") }
    val context = LocalContext.current

    Scaffold(
        containerColor = getBackgroundColor(),
        topBar = { AppTopBar("Add Note") },
        content = { padding ->

            CardView(modifier = Modifier.padding(padding).padding(start = 16.dp, top = 4.dp, end = 16.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    RoundedTextField(value = title, onValueChange = { title = it }, placeHolder = "Title")
                    SpaceVertical(8)
                    RoundedTextField(value = content, onValueChange = { content = it }, placeHolder = "Content")
                    SpaceVertical(8)
                    ColorPickerUI { color = it }
                    SpaceVertical(16)

                    Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top) {
                        AppButton(modifier = Modifier.fillMaxWidth(), text = "Cancel", isPositive = false, onClick = onCancel)
                        SpaceVertical(4)
                        AppButton(modifier = Modifier.fillMaxWidth(),text = "Add Note", isPositive = true, onClick = {
                            if (title.isBlank()) {
                                context.toast("Title cannot be empty")
                            } else {
                                onAdd(Note(title = title, content = content, color = color))
                            }
                        })
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAddNote() {
    AddNoteUI()
}