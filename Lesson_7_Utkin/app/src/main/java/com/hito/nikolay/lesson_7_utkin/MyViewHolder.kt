package com.hito.nikolay.lesson_7_utkin

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view_bridge.view.*
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.*

class MyViewHolder(view: View, private val listener: RecyclerViewAdapter.Listener) :
    RecyclerView.ViewHolder(view) {

    private val BRIDGE_LATE = "BRIDGE_LATE"
    private val BRIDGE_SOON = "BRIDGE_SOON"
    private val BRIDGE_OPEN = "BRIDGE_OPEN"


    fun bind(bridge: Bridge) {

        itemView.constraintLayoutItemBridge.setOnClickListener {
            listener.onItemClick(bridge)
        }

        val textViewBridgeName = itemView.findViewById<TextView>(R.id.textViewBridgeName)
        val textViewWorkingTime = itemView.findViewById<TextView>(R.id.textViewWorkingTime)

        textViewBridgeName.text = bridge.name
        textViewWorkingTime.text = getTimeDivorce(bridge.divorce)

        val bridgeImage = itemView.findViewById<ImageView>(R.id.imageViewRecycler)
        when (isBridgeOpen(bridge.divorce)) {
            BRIDGE_SOON -> bridgeImage.setImageResource(R.drawable.ic_brige_soon)
            BRIDGE_LATE -> bridgeImage.setImageResource(R.drawable.ic_brige_late)
            BRIDGE_OPEN -> bridgeImage.setImageResource(R.drawable.ic_brige_normal)
        }
    }

    companion object {
        val formatter = SimpleDateFormat("HH:mm", Locale("ru", "RU"))
        val parser = SimpleDateFormat("HH:mm:ss", Locale("ru", "RU"))
        var fullDateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale("ru", "RU"))


        fun getTimeDivorce(divorces: ArrayList<Divorce>): String {
            var workingTime = ""
            divorces.forEach {
                workingTime += formatter.format(parser.parse(it.start)) + " - " +
                        formatter.format(parser.parse(it.end)) + "    "
            }
            return workingTime
        }
    }


    fun isBridgeOpen(divorces: ArrayList<Divorce>): String {
        var currentTime = Date(System.currentTimeMillis())
        divorces.forEach {
            val startTime = parser.parse(it.start)
            val endTime = parser.parse(it.end)
            val startTimeMinusHour = Date(startTime.time - 3600 * 1000)

            if (currentTime.after(startTime) && currentTime.before(endTime))
                return BRIDGE_LATE
            /* if (startTimeMinusHour.before(currentTime))
                 return BRIDGE_SOON*/
        }
        return BRIDGE_OPEN
    }
}