package com.ram.notes.ui.layout

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
import androidx.compose.material3.MaterialTheme
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
import com.ram.notes.ui.components.RoundedTextField
import com.ram.notes.utils.getColorFromName
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

    val colorOptions = listOf("Red", "Green", "Blue", "Yellow", "Purple")

    Column(modifier = Modifier.padding(16.dp)) {
        RoundedTextField(value = title, onValueChange = { title = it }, label = "Title")
        Spacer(modifier = Modifier.height(8.dp))
        RoundedTextField(value = content, onValueChange = { content = it }, label = "Content")
        Spacer(modifier = Modifier.height(8.dp))

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
            AppButton(text = "Cancel", isPositive = false, onClick = onDismiss)
            Spacer(modifier = Modifier.width(16.dp))
            AppButton(text = "Update", isPositive = true, onClick = {

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
