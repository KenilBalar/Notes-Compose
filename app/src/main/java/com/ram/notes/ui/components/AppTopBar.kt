package com.ram.notes.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.ram.notes.ui.theme.getBackgroundColor
import com.ram.notes.ui.theme.getOnBackgroundColor

/**
 * @author ASUS
 * @date 25-05-2025
 */

@Composable
fun AppTopBar(title: String){
    TopBarUI(title)
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBar(){
    TopBarUI("Notes-Compose")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarUI(title: String){
    TopAppBar(title = { Text(title, fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = getBackgroundColor(),
            titleContentColor = getOnBackgroundColor()
        ))
}