package com.hito.nikolay.lesson_8_utkin.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = true)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
