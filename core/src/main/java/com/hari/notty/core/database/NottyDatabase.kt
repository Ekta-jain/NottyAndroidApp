package com.hari.notty.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hari.notty.core.BuildConfig
import com.hari.notty.core.database.dao.NoteDao
import com.hari.notty.core.database.entity.NoteEntity


@Database(
    entities = [NoteEntity::class],
    version = BuildConfig.NOTTY_DATABASE_VERSION,
    exportSchema = BuildConfig.NOTTY_DATABASE_EXPORT_SCHEMA
)
abstract class NottyDatabase:RoomDatabase() {
    abstract fun noteDao(): NoteDao
}