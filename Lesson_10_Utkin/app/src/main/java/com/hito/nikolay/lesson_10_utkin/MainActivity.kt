package com.hito.nikolay.lesson_10_utkin

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object {
        const val LOCATION_PERMISSION = 1
        const val SPB_LAT = 59.93863
        const val SPB_LNG = 30.31413
    }

    lateinit var disposable: Disposable
    lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isMyLocationButtonEnabled = false;


        disposable = GetData.getBridges().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                it.bridges.forEach { bridge ->
                    mMap.addMarker(markerOptionsForBridge(bridge)).tag = bridge
                }

                mMap.setOnMapClickListener {
                    constraintLayoutBridgeInfo.visibility = View.GONE
                }

                mMap.setOnMarkerClickListener { marker ->
                    bridgeInfo(marker.tag as Bridge)
                    return@setOnMarkerClickListener true
                }
            }, {
                it.printStackTrace()
            })

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(SPB_LAT, SPB_LNG), 12f))

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            LOCATION_PERMISSION -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    mMap.isMyLocationEnabled = true
                } else {
                    //mMap.isMyLocationEnabled = false
                }
                return
            }
        }
    }

    private fun markerOptionsForBridge(bridge: Bridge): MarkerOptions {
        val markerOptions = MarkerOptions()

        markerOptions.position(LatLng(bridge.lat, bridge.lng))
        when (Functions.isBridgeOpen(bridge.divorce)) {
            Functions.BRIDGE_LATE -> markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_brige_late))
            Functions.BRIDGE_OPEN -> markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_brige_normal_2))
            Functions.BRIDGE_SOON -> markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_brige_soon_2))
        }
        return markerOptions
    }

    private fun bridgeInfo(bridge: Bridge) {
        constraintLayoutBridgeInfo.visibility = View.VISIBLE
        when (Functions.isBridgeOpen(bridge.divorce)) {
            Functions.BRIDGE_LATE -> imageViewBridgeInfo.setImageResource(R.drawable.ic_brige_late)
            Functions.BRIDGE_OPEN -> imageViewBridgeInfo.setImageResource(R.drawable.ic_brige_normal_2)
            Functions.BRIDGE_SOON -> imageViewBridgeInfo.setImageResource(R.drawable.ic_brige_soon_2)
        }

        textViewBridgeInfoTitle.text = bridge.name
        textViewInfoDivorceTime.text = Functions.getTimeDivorce(bridge.divorce)
    }
}

