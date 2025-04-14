package com.ram.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.ram.notes.database.NoteDatabase
import com.ram.notes.navigation.NoteNavigation
import com.ram.notes.repository.NoteRepository
import com.ram.notes.ui.theme.NotesComposeTheme
import com.ram.notes.viewModelFactory.NoteViewModelFactory
import com.ram.notes.viewModels.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = NoteDatabase.getDatabase(this)
        val repository = NoteRepository(database.noteDao())
        val viewModelFactory = NoteViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[NoteViewModel::class.java]

        setContent {
            NotesComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NoteNavigation(viewModel)
                }
            }
        }
    }
}
