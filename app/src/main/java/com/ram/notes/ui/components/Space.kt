package com.ram.notes.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @author ASUS
 * @date 25-05-2025
 */
@Composable
fun Space(space:Int) {
    Spacer(modifier = Modifier.width(space.dp))

}