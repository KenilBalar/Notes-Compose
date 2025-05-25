package com.ram.notes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val LightPrimaryColor = Color(0xFF007764)
val LightOnPrimaryColor = Color(0xFFFFFFFF)

val LightSecondaryColor = Color(0xFF4C3E88)
val LightOnSecondaryColor = Color(0xFFFFFFFF)

val LightBackgroundColor = Color(0xFFFFFFFF)
val LightSurfaceColor = Color(0xFFE3E3E3)
val LightOnBackgroundColor = Color(0xFF000000)
val LightOnSurfaceColor = Color(0xFF1A1A1A)

val LightRedColor = Color(0xFFFFCDD2)
val LightGreenColor = Color(0xFFC8E6C9)
val LightBlueColor = Color(0xFFBBDEFB)
val LightYellowColor = Color(0xFFFFF9C4)
val LightPurpleColor = Color(0xFFF0B6FF)


val DarkPrimaryColor = Color(0xFF4BAAEC)
val DarkOnPrimaryColor = Color(0xFF000000)

val DarkSecondaryColor = Color(0xFF9EC98E)
val DarkOnSecondaryColor = Color(0xFF000000)

val DarkBackgroundColor = Color(0xFF000000)
val DarkSurfaceColor = Color(0xFF282828)
val DarkOnBackgroundColor = Color(0xFFFFFFFF)
val DarkOnSurfaceColor = Color(0xFFF5F5F5)

val DarkRedColor = Color(0xFF3F0007)
val DarkGreenColor = Color(0xFF003F1E)
val DarkBlueColor = Color(0xFF00193F)
val DarkYellowColor = Color(0xFF3F2D00)
val DarkPurpleColor = Color(0xFF13003F)

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



