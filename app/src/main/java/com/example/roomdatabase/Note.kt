package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(val text: String) {
    @PrimaryKey(autoGenerate = true) var id=0
}