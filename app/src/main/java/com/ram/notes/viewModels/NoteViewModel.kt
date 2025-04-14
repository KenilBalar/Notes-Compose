package com.ram.notes.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ram.notes.database.entity.Note
import com.ram.notes.repository.NoteRepository
import kotlinx.coroutines.launch

/**
 * @author ASUS
 * @date 12-04-2025
 */
class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val notes = repository.notes.asLiveData()

    fun addNote(title: String, content: String, color: String) {
        viewModelScope.launch {
            repository.addNote(Note(title = title, content = content, color = color))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.addNote(note)
        }
    }
}