package com.hito.nikolay.lesson_7_utkin

import io.reactivex.Single
import retrofit2.http.GET

interface GetData {
    @GET("bridges/?format=json")
    fun getData(): Single<BridgeList>
}