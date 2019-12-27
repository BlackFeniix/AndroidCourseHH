package com.hito.nikolay.lesson_8_utkin.database

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM note_table where isArchived = 0")
    fun getAllObservable(): Flowable<List<Note>>
}