package com.ram.notes.repository

import com.ram.notes.data.database.dao.NoteDao
import com.ram.notes.data.database.entity.Note
import kotlinx.coroutines.flow.Flow

/**
 * @author ASUS
 * @date 12-04-2025
 */
class NoteRepository(private val dao: NoteDao) {
    val notes: Flow<List<Note>> = dao.getAllNotes()
    suspend fun addNote(note: Note) = dao.insertNote(note)
    suspend fun deleteNote(note: Note) = dao.deleteNote(note)
}