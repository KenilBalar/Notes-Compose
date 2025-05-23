package com.ram.notes.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.ram.notes.database.entity.Note

/**
 * @author ASUS
 * @date 12-04-2025
 */

@Composable
fun NoteItem(note: Note, onEdit: (Note) -> Unit, onDelete: (Note) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (note.color) {
                "Red" -> Color(0xFFFFCDD2)
                "Green" -> Color(0xFFC8E6C9)
                "Blue" -> Color(0xFFBBDEFB)
                "Yellow" -> Color(0xFFFFF9C4)
                "Purple" -> Color(0xFFF0B6FF)
                else -> Color.LightGray
            }
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                Text(text = note.title, fontSize = TextUnit(18f, TextUnitType.Sp), fontWeight = FontWeight.Bold,modifier = Modifier.weight(1f))
                IconButton(modifier = Modifier.size(20.dp),onClick = { onEdit(note) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
                Spacer(modifier = Modifier.size(12.dp))
                IconButton(modifier = Modifier.size(20.dp),onClick = { onDelete(note) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
            Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(Color.Black.copy(alpha = 0.2f)))
            Column(modifier = Modifier.padding(top = 8.dp)) {
                Text(text = note.content, fontSize = TextUnit(14f, TextUnitType.Sp))
            }
        }
    }
}