package com.ram.notes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val LightPrimaryColor = Color(0xFF007764)
val LightOnPrimaryColor = Color(0xFFFFFFFF)

val LightSecondaryColor = Color(0xFF4C3E88)
val LightOnSecondaryColor = Color(0xFFFFFFFF)

val LightBackgroundColor = Color(0xFFFFFFFF)
val LightSurfaceColor = Color(0xFFFFFFFF)
val LightOnBackgroundColor = Color(0xFF000000)
val LightOnSurfaceColor = Color(0xFF1A1A1A)

val LightRedColor = Color(0xFFECB1B2)
val LightGreenColor = Color(0xFFB1ECB2)
val LightBlueColor = Color(0xFFB1D9EC)
val LightYellowColor = Color(0xFFECDDB1)
val LightPurpleColor = Color(0xFFCAB1EC)


val DarkPrimaryColor = Color(0xFF4BAAEC)
val DarkOnPrimaryColor = Color(0xFF000000)

val DarkSecondaryColor = Color(0xFF9EC98E)
val DarkOnSecondaryColor = Color(0xFF000000)

val DarkBackgroundColor = Color(0xFF000000)
val DarkSurfaceColor = Color(0xFF111111)
val DarkOnBackgroundColor = Color(0xFFFFFFFF)
val DarkOnSurfaceColor = Color(0xFFF5F5F5)

val DarkRedColor = Color(0xFF470F14)
val DarkGreenColor = Color(0xFF13470F)
val DarkBlueColor = Color(0xFF0F3547)
val DarkYellowColor = Color(0xFF473E0F)
val DarkPurpleColor = Color(0xFF290F47)

@Composable
fun getRedColor() : Color  {
    return if (!isSystemInDarkTheme()) LightRedColor else DarkRedColor
}

@Composable
fun getGreenColor() : Color  {
    return if (!isSystemInDarkTheme()) LightGreenColor else DarkGreenColor
}

@Composable
fun getBlueColor() : Color  {
    return if (!isSystemInDarkTheme()) LightBlueColor else DarkBlueColor
}

@Composable
fun getYellowColor() : Color  {
    return if (!isSystemInDarkTheme()) LightYellowColor else DarkYellowColor
}

@Composable
fun getPurpleColor() : Color  {
    return if (!isSystemInDarkTheme()) LightPurpleColor else DarkPurpleColor
}



@Composable
fun getBackgroundColor() = MaterialTheme.colorScheme.background

@Composable
fun getSurfaceColor() = MaterialTheme.colorScheme.surface

@Composable
fun getPrimaryColor() = MaterialTheme.colorScheme.primary

@Composable
fun getSecondaryColor() = MaterialTheme.colorScheme.secondary

@Composable
fun getOnBackgroundColor() = MaterialTheme.colorScheme.onBackground

@Composable
fun getOnSurfaceColor() = MaterialTheme.colorScheme.onSurface

@Composable
fun getOnPrimaryColor() = MaterialTheme.colorScheme.onPrimary

@Composable
fun getOnSecondaryColor() = MaterialTheme.colorScheme.onSecondary


