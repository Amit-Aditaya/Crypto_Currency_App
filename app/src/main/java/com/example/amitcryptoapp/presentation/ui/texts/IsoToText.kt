package com.example.amitcryptoapp.presentation.ui.texts

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun IsoToText(isoDate: String) {
    // Parse the ISO 8601 string
    val instant = Instant.parse(isoDate)
    val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a")
        .withZone(ZoneId.systemDefault()) // Adjust to the device's time zone

    // Format the date into a human-readable string
    val humanReadableDate = formatter.format(instant)

    // Display the date
    Text(text = humanReadableDate, style = TextStyle(color = Color.LightGray, fontStyle = FontStyle.Italic, fontSize = 12.sp))
}
