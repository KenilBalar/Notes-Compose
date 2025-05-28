package com.ram.notes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ram.notes.ui.theme.getSurfaceColor
import com.ram.notes.utils.getColorFromName

/**
 * @author ASUS
 * @date 28-05-2025
 */
@Composable
fun ColorPickerUI(noteColor: String = "Red",onColorPick: (String) -> Unit = {}){
    var color by rememberSaveable { mutableStateOf(noteColor) }
    val colorOptions = listOf("Red", "Green", "Blue", "Yellow", "Purple")

    Row(modifier = Modifier.fillMaxWidth()) {
        colorOptions.forEach { name ->
            Box(
                modifier = Modifier
                    .padding(end = 8.dp, top = 14.dp, bottom = 14.dp)
                    .size(44.dp)
                    .background(
                        color = getColorFromName(name),
                        shape = CircleShape
                    )
                    .clickable { color = name; onColorPick(color) }
                    .border(
                        width = if (color == name) 3.dp else 5.dp,
                        color = if (color == name) getColorFromName(name) else getSurfaceColor(),
                        shape = CircleShape
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewColorPicker(){
    ColorPickerUI()
}