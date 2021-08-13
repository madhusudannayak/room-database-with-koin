package com.example.roomdatabase

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    fun getAll() = noteDao.getAllNotes()

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}