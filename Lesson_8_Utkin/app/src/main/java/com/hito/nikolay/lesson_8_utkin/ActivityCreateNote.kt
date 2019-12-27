package com.hito.nikolay.lesson_8_utkin

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.hito.nikolay.lesson_8_utkin.database.Note
import com.hito.nikolay.lesson_8_utkin.database.NoteDatabase
import kotlinx.android.synthetic.main.activity_create_note.*


class ActivityCreateNote : AppCompatActivity() {
    companion object {
        const val NOTE_DATA = "NOTE_DATA"
        fun createStartIntent(context: Context?): Intent {
            return Intent(context, ActivityCreateNote::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        var noteId = 0
        val db = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java, "database"
        ).allowMainThreadQueries().build()

        if (intent.hasExtra(NOTE_DATA)) {
            val note = intent.getParcelableExtra<Note>(NOTE_DATA)
            noteId = note.id
            editTextNoteTitle.setText(note.title)
            editTextNoteDescription.setText(note.text)
            constraintLayoutNewNote.setBackgroundColor(note.color)
        }

        /*toolbar.inflateMenu(R.menu.menu_toolbar_detailed)
        toolbar.menu.findItem(R.id.menuItemColor).setOnMenuItemClickListener {

        }*/
        toolbar.setNavigationOnClickListener {
            db.noteDao().insertNote(
                Note(
                    noteId,
                    editTextNoteTitle.text.toString(),
                    editTextNoteDescription.text.toString(),
                    (constraintLayoutNewNote.background as ColorDrawable).color
                )
            )
            finish()
        }
    }
}


