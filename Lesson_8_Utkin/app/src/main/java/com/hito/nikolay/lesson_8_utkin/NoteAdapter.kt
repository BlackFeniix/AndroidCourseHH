package com.hito.nikolay.lesson_8_utkin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hito.nikolay.lesson_8_utkin.database.Note
import kotlinx.android.synthetic.main.item_note.view.*

// Если название пустое, то сделать вьюху gone и
class NoteAdapter(
    private val noteList: List<Note>,
    private val onClickListener: (Note) -> Unit,
    private val onLongClickListener: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.ViewHolderNote>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNote {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return ViewHolderNote(view, onClickListener, onLongClickListener)
    }

    override fun getItemCount(): Int = noteList.count()

    override fun onBindViewHolder(holder: ViewHolderNote, position: Int) {
        holder.bind(noteList[position])
    }

    inner class ViewHolderNote(
        view: View,
        private val onClickListener: (Note) -> Unit,
        private val onLongClickListener: (Note) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        fun bind(note: Note) {
            itemView.constraintLayoutCard.setOnClickListener {
                onClickListener(note)
            }
            itemView.constraintLayoutCard.setOnLongClickListener {
                onLongClickListener(note)
                return@setOnLongClickListener true
            }

            itemView.textViewCardTitle.text = note.title
            itemView.textViewCardDescription.text = note.text
            itemView.constraintLayoutCard.setBackgroundColor(note.color)
        }
    }
}
