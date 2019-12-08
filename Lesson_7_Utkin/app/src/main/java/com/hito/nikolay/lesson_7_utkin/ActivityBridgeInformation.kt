package com.hito.nikolay.lesson_7_utkin

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityBridgeInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bridge_information)

        val bridge = intent.getParcelableExtra<Bridge>(BRIDGE_INFO)
        if (bridge != null) {
            val textViewBridgePageName = findViewById<TextView>(R.id.textViewBridgePageName)
            textViewBridgePageName.text = bridge.name

            val textViewBridgeText = findViewById<TextView>(R.id.textViewBridgeText)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                textViewBridgeText.text = Html.fromHtml(bridge.description, Html.FROM_HTML_MODE_LEGACY)
            else
                textViewBridgeText.text = Html.fromHtml(bridge.description)

            val textViewPageWorkingTime = findViewById<TextView>(R.id.textViewPageWorkingTime)
            textViewPageWorkingTime.text = MyViewHolder.getTimeDivorce(bridge.divorce)

            val imageViewBridgePage = findViewById<ImageView>(R.id.imageViewBridgePage)
            imageViewBridgePage.setImageResource(R.drawable.ic_brige_soon)
        }
    }

    companion object {
        val BRIDGE_INFO: String = "BRIDGE_INFO"
        fun createStartIntent(context: Context?, bridge: Bridge): Intent? {
            var intent = Intent(context, ActivityBridgeInformation::class.java)
            intent.putExtra(BRIDGE_INFO, bridge)
            return intent
        }
    }
}
