package com.hito.nikolay.lesson_7_utkin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://gdemost.handh.ru/api/v1/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewBridges = findViewById<RecyclerView>(R.id.recyclerViewBridges)
        recyclerViewBridges.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val requestInterface = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetData::class.java)

        requestInterface.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    //Убрать прогресс бар
                    progressBar.visibility = View.INVISIBLE
                    recyclerViewBridges.adapter = RecyclerViewAdapter(it.bridges,
                        object : RecyclerViewAdapter.Listener {
                            override fun onItemClick(bridge: Bridge) {
                                startActivity(
                                    ActivityBridgeInformation.createStartIntent(
                                        this@MainActivity,
                                        bridge
                                    )
                                )
                            }
                        })
                },
                {
                    //Ошибка
                }
            )
            .isDisposed
    }
}