package com.hari.notty.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
   @PrimaryKey(autoGenerate = true) val id:Int
)
