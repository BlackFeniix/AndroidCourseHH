package com.hito.nikolay.lesson_10_utkin

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class BridgeList(
    @SerializedName("objects") val bridges: ArrayList<Bridge>
)

@Parcelize
data class Bridge(
    @SerializedName("id") val id: Int,
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double,
    @SerializedName("name") val name: String,
    @SerializedName("divorces") val divorce: ArrayList<Divorce>
) : Parcelable

@Parcelize
data class Divorce(
    @SerializedName("id") val id: Int,
    @SerializedName("start") val start: String,
    @SerializedName("end") val end: String
) : Parcelable