package com.ram.notes.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.ram.notes.data.database.entity.Note
import com.ram.notes.ui.components.CardView
import com.ram.notes.ui.components.SpaceHorizontal
import com.ram.notes.ui.theme.getOnBackgroundColor
import com.ram.notes.utils.getColorFromName

/**
 * @author ASUS
 * @date 12-04-2025
 */
@Composable
fun NoteUI(note: Note, onEdit: (Note) -> Unit = {}, onDelete: (Note) -> Unit = {}){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 4.dp)
            .clickable {
                onEdit(note)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = getColorFromName(note.color)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Row {
                Text(text = note.title, fontSize = TextUnit(18f, TextUnitType.Sp), fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                SpaceHorizontal(12)

                CardView{
                    IconButton(modifier = Modifier.size(28.dp).padding(4.dp), onClick = { onDelete(note) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete",
                                tint = getOnBackgroundColor())
                    }
                }
            }
            if (note.content.trim().isNotEmpty()) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)) {
                    Text(text = note.content, fontSize = TextUnit(14f, TextUnitType.Sp), modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotePreview() {
    NoteUI(Note(0,"Android Concepts","Kotlin Flows\nCoroutines\nMVVM Architecture\nJetpack Compose\nRxJava/RxKotlin\nRetrofit\nFirebase\nUnit Tests ","Blue"))
}
