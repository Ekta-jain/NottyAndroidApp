package com.hari.notty.core.database

import com.hari.notty.core.database.entity.NoteEntity
import com.hari.notty.core.database.model.NoteDatabase
import javax.inject.Inject

class NoteDatabaseImpl @Inject constructor():NoteDatabase {
    override suspend fun insertNote(noteEntity: NoteEntity) {
        println("Note Inserted.")
    }
}