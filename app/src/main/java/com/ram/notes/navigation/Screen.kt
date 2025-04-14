package com.ram.notes.navigation

/**
 * @author ASUS
 * @date 14-04-2025
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddEditNote : Screen("add_edit_note")
}