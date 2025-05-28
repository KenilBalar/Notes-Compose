package com.ram.notes.ui.navigation

/**
 * @author ASUS
 * @date 14-04-2025
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddNote : Screen("add_note")
}