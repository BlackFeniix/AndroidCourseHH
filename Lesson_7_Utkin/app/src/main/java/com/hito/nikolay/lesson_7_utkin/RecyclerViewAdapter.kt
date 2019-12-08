package com.hito.nikolay.lesson_7_utkin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class RecyclerViewAdapter(private val bridgeList: ArrayList<Bridge>, private val listener: Listener) :
    RecyclerView.Adapter<MyViewHolder>() {

    interface Listener{
        fun onItemClick(bridge: Bridge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recycler_view_bridge, parent, false)
        return MyViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(bridgeList[position])
    }

    override fun getItemCount(): Int  = bridgeList.count()
}