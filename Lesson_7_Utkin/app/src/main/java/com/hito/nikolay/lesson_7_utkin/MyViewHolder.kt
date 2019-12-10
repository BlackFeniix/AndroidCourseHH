package com.hito.nikolay.lesson_7_utkin

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view_bridge.view.*
import java.text.SimpleDateFormat
import java.util.*

class MyViewHolder(view: View, private val listener: RecyclerViewAdapter.Listener) :
    RecyclerView.ViewHolder(view) {

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
        const val BRIDGE_LATE = "BRIDGE_LATE"
        const val BRIDGE_SOON = "BRIDGE_SOON"
        const val BRIDGE_OPEN = "BRIDGE_OPEN"

        private val formatter = SimpleDateFormat("HH:mm", Locale("ru", "RU"))
        private val parser = SimpleDateFormat("HH:mm:ss", Locale("ru", "RU"))

        fun getTimeDivorce(divorces: ArrayList<Divorce>): String {
            var workingTime = ""
            divorces.forEach {
                workingTime += formatter.format(parser.parse(it.start)) + " - " +
                        formatter.format(parser.parse(it.end)) + "    "
            }
            return workingTime
        }

        fun isBridgeOpen(divorces: ArrayList<Divorce>): String {
            val currentTime =
                formatter.parse(formatter.format(Date(System.currentTimeMillis())))
            divorces.forEach {
                val startTime = formatter.parse(it.start)
                val endTime = formatter.parse(it.end)
                val startTimeMinusHour = Date(startTime.time - 3600 * 1000)

                if (currentTime.after(startTime) && currentTime.before(endTime))
                    return BRIDGE_LATE
                if (startTimeMinusHour.before(currentTime) && currentTime.before(startTime))
                    return BRIDGE_SOON
            }
            return BRIDGE_OPEN
        }
    }
}