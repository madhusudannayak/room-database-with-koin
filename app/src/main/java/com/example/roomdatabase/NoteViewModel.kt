package com.example.roomdatabase

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class NoteViewModel(val repository: NoteRepository) : ViewModel() {
//    val allNotes: LiveData<List<Note>>
//    val repository: NoteRepository
//
//    init {
//        val dao = NoteDatabase.getDatabase(application).getNoteDao()
//        repository = NoteRepository(dao)
//        allNotes = repository.allNotes
//    }
val clientes :  LiveData<List<Note>>

init {
    clientes = repository.allNotes
}

    fun getAllClientes() {
        viewModelScope.launch {

        }
    }

    fun deleteNode(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }
}