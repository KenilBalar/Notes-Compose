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
import com.ram.notes.ui.theme.getOnPrimaryColor
import com.ram.notes.ui.theme.getPrimaryColor
import com.ram.notes.ui.theme.getSurfaceColor

/**
 * @author ASUS
 * @date 25-05-2025
 */

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    isPositive: Boolean = true,
    onClick:  () -> Unit
) {
    if (isPositive){

        Button(
            modifier = modifier,
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor =getPrimaryColor(),
                contentColor = getOnPrimaryColor()
            )
        ) {
            Text(text = text)
        }
    }
    else{
        Button (
            modifier = modifier,
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
            containerColor =getPrimaryColor().copy(0.1f),
            contentColor = getPrimaryColor()
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
            containerColor = getSurfaceColor(),
            contentColor = getPrimaryColor()
        )
    ) {
        Text("Click me")
    }
}