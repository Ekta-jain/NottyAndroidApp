package com.hari.notty.core.database.model

import com.hari.notty.core.database.entity.NoteEntity

interface NoteDatabase {
    suspend fun insertNote(noteEntity: NoteEntity)
}