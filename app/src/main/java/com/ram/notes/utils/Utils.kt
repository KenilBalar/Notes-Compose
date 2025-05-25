package com.ram.notes.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ram.notes.ui.theme.getBlueColor
import com.ram.notes.ui.theme.getGreenColor
import com.ram.notes.ui.theme.getPurpleColor
import com.ram.notes.ui.theme.getRedColor
import com.ram.notes.ui.theme.getYellowColor

/**
 * @author ASUS
 * @date 25-05-2025
 */
@Composable
fun getColorFromName(name: String = ""): Color{
    return  when (name) {
        "Red" -> getRedColor()
        "Green" -> getGreenColor()
        "Blue" -> getBlueColor()
        "Yellow" -> getYellowColor()
        "Purple" -> getPurpleColor()
        else -> MaterialTheme.colorScheme.background
    }
}