package com.ram.notes.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

/**
 * @author ASUS
 * @date 25-05-2025
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(title: String){
    TopAppBar(title = { Text(title, fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.secondary
        ))

}