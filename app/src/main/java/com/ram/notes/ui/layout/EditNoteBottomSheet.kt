package com.ram.notes.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.ram.notes.ui.components.ColorPickerUI
import com.ram.notes.ui.components.RoundedTextField
import com.ram.notes.ui.components.SpaceHorizontal
import com.ram.notes.ui.components.SpaceVertical
import com.ram.notes.utils.toast

/**
 * @author ASUS
 * @date 28-05-2025
 */

@Composable
fun BottomSheetUI(note: Note, onUpdate: (Note) -> Unit = {}, onDismiss: () -> Unit = {}) {

    var title by rememberSaveable { mutableStateOf(note.title) }
    var content by rememberSaveable { mutableStateOf(note.content) }
    var color by rememberSaveable { mutableStateOf(note.color) }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        RoundedTextField(value = title, onValueChange = { title = it }, placeHolder = "Title")
        SpaceVertical(8)
        RoundedTextField(value = content, onValueChange = { content = it }, placeHolder = "Content")
        SpaceVertical(8)

        ColorPickerUI(color) { color = it }

        SpaceVertical(16)
        Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top) {
            AppButton(modifier = Modifier.fillMaxWidth(), text = "Cancel", isPositive = false, onClick = onDismiss)
            SpaceVertical(4)
            AppButton(modifier = Modifier.fillMaxWidth(),text = "Update", isPositive = true, onClick = {
                if (title.isBlank()) {
                    context.toast("Title cannot be empty")
                } else {
                    onUpdate(note.copy(title = title, content = content, color = color))
                    onDismiss()
                }
            })
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewBottomSheet() {
    BottomSheetUI(Note(1, "Rent", "Last date to pay rent 25th June 2025", "Red"))
}