package com.hito.nikolay.lesson_8_utkin

import android.net.sip.SipAudioCall
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val bridgeList: ArrayList<Int>,
    private val listener: SipAudioCall.Listener
) : RecyclerView.Adapter<ViewHolderNote>() {

    interface Listener{
        fun onItemClick(bridge: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNote {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolderNote, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}