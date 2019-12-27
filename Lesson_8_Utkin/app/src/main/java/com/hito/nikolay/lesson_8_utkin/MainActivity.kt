package com.hito.nikolay.lesson_8_utkin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.room.Room
import com.hito.nikolay.lesson_8_utkin.database.Note
import com.hito.nikolay.lesson_8_utkin.database.NoteDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/*
adb forward tcp:8080 tcp:8080
http://localhost:8080/

alertDialog при долгом нажатии
*/

class MainActivity : AppCompatActivity() {
    lateinit var disposable: Disposable
    lateinit var db: NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewNotes.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        recyclerViewNotes.addItemDecoration(
            NoteGridSpacingDecorator(
                resources.getDimensionPixelSize(
                    R.dimen.item_offset
                )
            )
        )

        floatingActionButton.setOnClickListener {
            startActivity(ActivityCreateNote.createStartIntent(this@MainActivity))
        }
        db = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java, "database"
        ).allowMainThreadQueries().build()
    }

    override fun onResume() {
        super.onResume()
        disposable = db.noteDao().getAllObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    progressBar.visibility = View.INVISIBLE
                    recyclerViewNotes.adapter = NoteAdapter(
                        it,
                        { note: Note -> itemClicked(note) },
                        { note: Note -> itemLongClicked(note) }
                    )
                },
                {
                    progressBar.visibility = View.VISIBLE
                    //Ошибка
                }
            )
    }

    private fun itemClicked(note: Note) {
        val intent = ActivityCreateNote.createStartIntent(this@MainActivity)
        intent.putExtra(ActivityCreateNote.NOTE_DATA, note)
        startActivity(intent)
    }

    private fun itemLongClicked(note: Note) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Выберите действие")
        builder.setNegativeButton("Удалить") { _, _ -> db.noteDao().delete(note) }
        builder.setPositiveButton("Архивировать") { _, _ ->
            note.isArchived = true
            db.noteDao().updateNote(note)
        }
        builder.create().show()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.isDisposed
    }
}
