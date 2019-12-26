package com.hito.nikolay.lesson_10_utkin

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GetData {
    @GET("bridges/?format=json")
    fun getData(): Single<BridgeList>

    companion object {
        private val BASE_URL = "https://gdemost.handh.ru/api/v1/"

        fun getBridges(): GetData {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GetData::class.java)
        }
    }
}