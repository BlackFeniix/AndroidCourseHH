package com.hito.nikolay.lesson_10_utkin

import java.text.SimpleDateFormat
import java.util.*

object Functions {
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