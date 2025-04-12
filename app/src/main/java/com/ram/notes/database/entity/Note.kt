package com.ram.notes.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author ASUS
 * @date 12-04-2025
 */
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val color: String
)