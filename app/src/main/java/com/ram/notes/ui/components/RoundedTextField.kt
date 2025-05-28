package com.ram.notes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ram.notes.ui.theme.getSurfaceColor
import androidx.compose.material3.OutlinedTextField as OutlinedTextField1

/**
 * @author ASUS
 * @date 28-05-2025
 */
@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String
) {
    TextFieldUI(value = value, onValueChange = onValueChange, placeHolder = placeHolder)
}

@Composable
fun TextFieldUI(value: String, onValueChange: (String) -> Unit = {}, placeHolder: String) {
    OutlinedTextField1(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeHolder) },
        modifier = Modifier
            .fillMaxWidth()
            .background(getSurfaceColor(), RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextField() {
    TextFieldUI("", placeHolder = "Title")
}