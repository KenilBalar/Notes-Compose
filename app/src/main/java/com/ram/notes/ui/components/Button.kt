package com.ram.notes.ui.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author ASUS
 * @date 25-05-2025
 */

@Composable
fun AppButton(
    text: String,
    isPositive: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isPositive){

        Button(
            onClick = onClick,
            modifier = modifier,
            shape = RoundedCornerShape(16.dp), // Rounded corners
            colors = ButtonDefaults.buttonColors(
                containerColor =MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(text = text)
        }
    }
    else{
        TextButton (
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
            containerColor =MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        )) { Text(text) }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewButton(){
    Button(
        onClick = {  },
        modifier = Modifier,
        shape = RoundedCornerShape(24.dp), // Rounded corners
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text("Click me")
    }
}