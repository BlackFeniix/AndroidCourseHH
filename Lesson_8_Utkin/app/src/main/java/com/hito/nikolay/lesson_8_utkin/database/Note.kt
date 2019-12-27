package com.hito.nikolay.lesson_8_utkin.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "note_table")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var text: String,
    @ColumnInfo(name = "color") var color: Int,
    @ColumnInfo(name = "isArchived") var isArchived: Boolean = false
) : Parcelable